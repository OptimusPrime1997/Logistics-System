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
import VO.BusinessFormVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime)
			throws NotFoundMoneyInAndOutException {
		System.out.println(startTime);
		System.out.println(endTime);
		ArrayList<ArrayList<PayRepVO>> moneyOut = new ArrayList<ArrayList<PayRepVO>>();
		ArrayList<ArrayList<CashRepVO>> moneyIn = new ArrayList<ArrayList<CashRepVO>>();
		// 检验过的 合法时间
		String tempT = startTime;
		PayRepbl ctr_payRep = new PayRepbl();
		CashRepbl ctr_cashRep = new CashRepbl();
		System.out.println("BusinessFormbl.show");
		//收款单们
		while (CurrentTime.ifearlier(tempT, endTime)) {
			try {
				if (ctr_cashRep.getAllRepByDate(tempT) != null)
					moneyIn.add(ctr_cashRep.getAllRepByDate(tempT));
				tempT = CurrentTime.addDate(tempT, 1);
				// 最后一天没加
				if (ctr_cashRep.getAllRepByDate(tempT) != null)
					moneyIn.add(ctr_cashRep.getAllRepByDate(tempT));
			} catch (ClassNotFoundException | IOException | NotBoundException e) {
			}
		}
//		while(CurrentTime.ifearlier(tempT, endTime)){
//			
//		}
		/*
		 * //付款单们
			if (ctr_payRep.getRepByDate(tempT) != null)
				moneyOut.add(ctr_payRep.getRepByDate(tempT));
			
		 */
		// 最后一天没加
//		if (ctr_payRep.getRepByDate(tempT) != null)
//			moneyOut.add(ctr_payRep.getRepByDate(tempT));
//		
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

}
