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
/**
 * 想测试的话    把两个引用的bl都加上Mock 
 * 
 */
public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime)
			throws NotFoundMoneyInAndOutException {
		ArrayList<ArrayList<PayRepVO>> moneyOut = new ArrayList<ArrayList<PayRepVO>>();
		ArrayList<ArrayList<CashRepVO>> moneyIn = new ArrayList<ArrayList<CashRepVO>>();
		ArrayList<CashRepVO> inTemp;
		ArrayList<PayRepVO> outTemp;
		// 检验过的 合法时间
		String tempT = startTime;
		/*
		 * to test
		 * 
		 *PayRepbl-->mockPayRepbl
		 *CashRepbl-->MockCashRepbl		 * 
		 */
		PayRepbl ctr_payRep = new PayRepbl();
		CashRepbl ctr_cashRep = new CashRepbl();
		System.out.println("BusinessFormbl.show");
		int i = 0;
		try {
			if (CurrentTime.ifsame(tempT, endTime)) {
				System.out.println("同一天");
				System.out.println(tempT);
				outTemp = ctr_payRep.getRepByDate(tempT);
				inTemp = ctr_cashRep.getRepByDate(tempT);
				if (outTemp != null)
					moneyOut.add(outTemp);
				if (inTemp != null)
					moneyIn.add(inTemp);
			} else {
				System.out.println("不同天");
				while (CurrentTime.ifearlier(tempT, endTime)) {
					System.out.println(tempT);
					outTemp = ctr_payRep.getRepByDate(tempT);
					inTemp = ctr_cashRep.getRepByDate(tempT);
					if (outTemp != null)
						moneyOut.add(outTemp);
					if (inTemp != null)
						moneyIn.add(inTemp);
					tempT = CurrentTime.addDate(tempT, 1);
				}
				// 最后一天没加
				outTemp = ctr_payRep.getRepByDate(tempT);
				inTemp = ctr_cashRep.getRepByDate(tempT);
				if (outTemp != null)
					moneyOut.add(outTemp);
				if (inTemp != null)
					moneyIn.add(inTemp);
			}
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			if (moneyIn.size() == 0 && moneyOut.size() == 0) {
				throw new NotFoundMoneyInAndOutException();
			}
		}

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
