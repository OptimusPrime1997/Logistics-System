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
import Exception.NotFoundMoneyInAndOutException;
import Exception.NumNotFoundException;
import VO.BusinessFormVO;
import VO.LogVO;
import VO.Receipt.CashRepVO;
import VO.Receipt.PayRepVO;
import bl.logbl.Logbl;
import bl.loginbl.Loginbl;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	String ip=Loginbl.getIP();
	Logbl ctr_log=new Logbl();
	public BusinessFormVO show(String startTime, String endTime)
			throws NotFoundMoneyInAndOutException {
		//0,1,2分别是年、月、日
		String[] startT=startTime.split("-");
		String[] endT=endTime.split("-");
		ArrayList<PayRepVO> moneyOut = new ArrayList<PayRepVO>();
		ArrayList<ArrayList<CashRepVO>> moneyIn = new ArrayList<ArrayList<CashRepVO>>();
		 //检验过的 合法时间
		String tempT = startTime;
		//收款单们
		while (CurrentTime.ifearlier(tempT, endTime)) {
			try {
				if (ctr_cashRep.getAllRepByDate(tempT) != null)
					moneyIn.add(ctr_cashRep.getAllRepByDate(tempT));
			} catch (ClassNotFoundException | IOException | NotBoundException e) {
				throw new NotFoundMoneyInAndOutException();
			}
			tempT=CurrentTime.addDate(tempT, 1);
		}
		// 最后一天没加
		
		try {
			if (ctr_cashRep.getAllRepByDate(tempT) != null)
				moneyIn.add(ctr_cashRep.getAllRepByDate(tempT));
		} catch (ClassNotFoundException | IOException | NotBoundException e1) {
			throw new NotFoundMoneyInAndOutException();
		}
		tempT=startT[0]+"-"+startT[1];
		while(CurrentTime.ifMonthearlier(tempT, endT[0]+"-"+endT[1])){
			  //付款单们
				try {
					if (ctr_payRep.getRepByNum(tempT) != null)
						moneyOut.add(ctr_payRep.getRepByNum(tempT));
				} catch (ClassNotFoundException | NotBoundException
						| IOException | NumNotFoundException e) {
					throw new NotFoundMoneyInAndOutException();
				}
				tempT=CurrentTime.addMonth(tempT, 1);
		}
		// 最后一天没加
		try {
			tempT = tempT.replace("-", "");
			if (ctr_payRep.getRepByNum(tempT) != null)
				moneyOut.add(ctr_payRep.getRepByNum(tempT));
		} catch (ClassNotFoundException | NotBoundException | IOException
				| NumNotFoundException e) {
			throw new NotFoundMoneyInAndOutException();
		}
		tempT = CurrentTime.addDate(tempT, 1);
		if (moneyIn.size() == 0 && moneyOut.size() == 0) {
			throw new NotFoundMoneyInAndOutException();
		}
		//这个操作不会失败，，即使连接出现问题也会返回初始化了的VO，即里面数据都是0
		LogVO logvo = new LogVO(LogType.CHECK_FORM,
				Loginbl.getCurrentOptorId(), CurrentTime.getTime());		
		ctr_log.add(logvo);
		return new BusinessFormVO(startTime, endTime, moneyOut, moneyIn);
	}

	public ResultMessage save(BusinessFormVO vo) {
		try {
			return getBFormData().add(BusinessFormVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	private BusinessFormDataService getBFormData() {
		BusinessFormDataService service = null;
		try {
			service = (BusinessFormDataService) Naming.lookup("rmi://"+ip+":1099/business");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	private PayRepbl ctr_payRep=new PayRepbl() ;
	private CashRepbl ctr_cashRep=new CashRepbl();

}
