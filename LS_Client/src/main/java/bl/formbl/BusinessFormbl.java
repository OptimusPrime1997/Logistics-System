package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.ResultMessage;
import VO.BusinessFormVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	public BusinessFormVO show(String startTime, String endTime) {
		ArrayList<ArrayList<PayRepVO>> moneyOut=new ArrayList<ArrayList<PayRepVO>>();
		ArrayList<ArrayList<CashRepVO>> moneyIn=new ArrayList<ArrayList<CashRepVO>>();
		//检验过的  合法时间 
		String tempT=startTime;
		PayRepbl ctr_payRep=new PayRepbl();
		CashRepbl ctr_cashRep=new CashRepbl();
		
		try {
			while(CurrentTime.ifearlier(tempT, endTime)){
				moneyOut.add(ctr_payRep.getRepByDate(tempT));
				moneyIn.add(ctr_cashRep.getRepByDate(tempT));
				tempT=CurrentTime.addDate(tempT, 1);
			}
			//最后一天没加
			moneyOut.add(ctr_payRep.getRepByDate(endTime));
			moneyIn.add(ctr_cashRep.getRepByDate(endTime));
			return new BusinessFormVO(startTime, endTime, moneyOut, moneyIn);			
			
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
		}
		return null;
	}
	
	public ResultMessage save(BusinessFormVO vo) {
		try {
			return 	getBFormData().add(BusinessFormVO.toPO(vo));
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
