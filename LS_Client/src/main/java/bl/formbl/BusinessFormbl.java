package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.ResultMessage;
import Exception.NotFoundMoneyInAndOutException;
import Exception.NumNotFoundException;
import VO.BusinessFormVO;
import VO.Receipt.CashRepVO;
import VO.Receipt.PayRepVO;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime)
			throws NotFoundMoneyInAndOutException {
		//0,1,2分别是年、月、日
		String[] startT=startTime.split("-");
		String[] endT=endTime.split("-");
		ArrayList<PayRepVO> moneyOut = new ArrayList<PayRepVO>();
		ArrayList<ArrayList<CashRepVO>> moneyIn = new ArrayList<ArrayList<CashRepVO>>();
//		 检验过的 合法时间
		String tempT = startTime;
		//收款单们
		System.out.println("收款单日期");
		while (CurrentTime.ifearlier(tempT, endTime)) {
			System.out.println(tempT);
			try {
				if (ctr_cashRep.getAllRepByDate(tempT) != null)
					moneyIn.add(ctr_cashRep.getAllRepByDate(tempT));
			} catch (ClassNotFoundException | IOException | NotBoundException e) {
			}
			tempT=CurrentTime.addDate(tempT, 1);
		}
		System.out.println(tempT);
//		// 最后一天没加
		try {
			if (ctr_cashRep.getAllRepByDate(tempT) != null)
				moneyIn.add(ctr_cashRep.getAllRepByDate(tempT));
		} catch (ClassNotFoundException | IOException | NotBoundException e1) {
		}
		tempT=startT[0]+"-"+startT[1];
		System.out.println("我给了你多少 "+moneyIn.get(0).get(0).date);
		System.out.println("付款单日期：");
		while(CurrentTime.ifMonthearlier(tempT, endT[0]+"-"+endT[1])){
			System.out.println(tempT);
			  //付款单们
				try {
					if (ctr_payRep.getRepByNum(tempT) != null)
						moneyOut.add(ctr_payRep.getRepByNum(tempT));
				} catch (ClassNotFoundException | NotBoundException
						| IOException | NumNotFoundException e) {
				}
				tempT=CurrentTime.addMonth(tempT, 1);
		}
		System.out.println(tempT);
		// 最后一天没加
		try {
			if (ctr_payRep.getRepByNum(tempT) != null)
				moneyOut.add(ctr_payRep.getRepByNum(tempT));
		} catch (ClassNotFoundException | NotBoundException | IOException
				| NumNotFoundException e) {
			
		}
		System.out.println("我给了你多少 "+moneyOut.get(0).date);
		tempT = CurrentTime.addDate(tempT, 1);
		System.out.println("收入 " + moneyIn.size());
		System.out.println("支出 " + moneyOut.size());
		if (moneyIn.size() == 0 && moneyOut.size() == 0) {
			throw new NotFoundMoneyInAndOutException();
		}
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
			service = (BusinessFormDataService) Naming.lookup("business");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return service;
	}
	private MockPayRepbl ctr_payRep=new MockPayRepbl() ;
	private MockCashRepbl ctr_cashRep=new MockCashRepbl();

}
