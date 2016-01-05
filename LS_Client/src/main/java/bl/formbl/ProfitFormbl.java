package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import VO.LogVO;
import VO.ProfitFormVO;
import VO.Receipt.CashRepVO;
import VO.Receipt.PayRepVO;
import bl.logbl.Logbl;
import bl.loginbl.Loginbl;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	String ip=Loginbl.getIP();
	Logbl ctr_log=new Logbl();
	public ProfitFormVO show(){
		double totalIn=0,totalOut=0,totalProfit=0;
		//TODO 待改回真的Repbl
		PayRepbl ctr_payRep=new PayRepbl();
		CashRepbl ctr_cashRep=new CashRepbl();
		
		ArrayList<PayRepVO> moneyOut=null;
		ArrayList<CashRepVO> moneyIn=null;
		try {
			moneyOut = ctr_payRep.getAllRep();
			 moneyIn = ctr_cashRep.getAllRep();
		} catch (ClassNotFoundException | IOException | NotBoundException e) {
		}
		
		//TODO //算钱！
		if(moneyIn!=null){
			for(CashRepVO cashR:moneyIn){
				totalIn=totalIn+cashR.sum;
			}
		}
		if(moneyOut!=null){
			for(PayRepVO payR:moneyOut){
				totalOut=totalOut+payR.sum;
			}
		}
		totalProfit=totalIn-totalOut;
		//这个操作不会失败，即使网络连接出现问题也会返回初始化数据，即0
		LogVO logvo = new LogVO(LogType.CHECK_FORM,
				Loginbl.getCurrentOptorId(), CurrentTime.getTime());		
		ctr_log.add(logvo);
	    ProfitFormVO vo = new ProfitFormVO(CurrentTime.getTime(), totalOut, totalIn, totalProfit);
		return vo;
	}

	public ResultMessage save(ProfitFormVO vo) {
		try {
			return getPFormData().add(vo.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
		
	}
	private ProfitFormDataService getPFormData(){
		ProfitFormDataService service=null;
		try {
			service=(ProfitFormDataService)Naming.lookup("rmi://"+ip+":1099/profit");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}

}
