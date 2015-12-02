package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import RMIClient.FormClient;
import VO.BusinessFormVO;
import VO.CashVO;
import VO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime) throws NotBoundException, ClassNotFoundException, IOException {
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		//TODO 改成  返回部分付款单，收款单的方法~
		ArrayList<PayRepVO> moneyOut = payRep.getAllRep();
		ArrayList<CashVO> moneyIn = cashRep.getAllRep();
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
