package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.ResultMessage;
import VO.ProfitFormVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	
	public ProfitFormVO show() throws NotBoundException, ClassNotFoundException, IOException {
		double totalIn=0,totalOut=0,totalProfit=0;
		PayRepbl ctr_payRep=new PayRepbl();
		CashRepbl ctr_cashRep=new CashRepbl();
		
		ArrayList<PayRepVO> moneyOut = ctr_payRep.getAllRep();
		ArrayList<CashRepVO> moneyIn = ctr_cashRep.getAllRep();
		//TODO 
		//算钱！
		for(PayRepVO payR:moneyOut){
			totalOut=totalOut+payR.sum;
		}
		for(CashRepVO cashR:moneyIn){
			totalIn=totalIn+cashR.sum;
		}
		totalProfit=totalIn-totalOut;
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
			service=(ProfitFormDataService)Naming.lookup("profit");
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
