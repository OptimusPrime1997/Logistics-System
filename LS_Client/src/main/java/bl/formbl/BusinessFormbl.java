package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.BusinessFormVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime) throws NotBoundException, ClassNotFoundException, IOException {
		String tempT=startTime;
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		//TODO 改成  返回部分付款单，收款单的方法~
//		ArrayList<PayRepVO> moneyOut = payRep.getAllRep();
//		while()
//		
//		ArrayList<CashVO> moneyIn = cashRep.getRepByDate("4");
//		BusinessFormVO vo =new BusinessFormVO(startTime, endTime, moneyOut, moneyIn);
		return null;
	}
	
	public ResultMessage save(BusinessFormVO vo) {
		try {
			return 	getBFormData().add(vo.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}
	private BusinessFormDataService getBFormData(){
		BusinessFormDataService service=null;
		try {
			service=(BusinessFormDataService)Naming.lookup("business");
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
