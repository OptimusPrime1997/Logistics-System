package bl.formbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import RMIClient.FormClient;
import VO.BusinessFormVO;
import VO.CashRepVO;
import VO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime) throws RemoteException {
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		//TODO 改成  返回部分付款单，收款单的方法~
		ArrayList<PayRepVO> moneyOut = payRep.getAllPayRep();
		ArrayList<CashRepVO> moneyIn = cashRep.getAllRep();
		BusinessFormVO vo =new BusinessFormVO(startTime, endTime, moneyOut, moneyIn);
		return vo;
	}
	
	public ResultMessage save(BusinessFormVO vo) {
		try {
			return 	getBFormData().add(vo.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}
	private FormClient client=new FormClient();
	private BusinessFormDataService getBFormData(){
		BusinessFormDataService service=null;
		try {
			service=client.getBusinessFormDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}

}
