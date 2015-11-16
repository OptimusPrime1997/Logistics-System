package bl.formbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.DataFactory;
import VO.BusinessFormVO;
import VO.CashRepVO;
import VO.PayRepVO;
import bl.receiptbl.CashRepblImpl;
import bl.receiptbl.PayRepblImpl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	BusinessFormDataService busiFormdata = DataFactory.getBusinessFormdata();
	
	public BusinessFormVO show(String startTime, String endTime) {
		PayRepblImpl payRep=new PayRepblImpl();
		CashRepblImpl cashRep=new CashRepblImpl();
		//all reps about money
		ArrayList<PayRepVO> moneyIn;
		ArrayList<CashRepVO> moneyOut;
		moneyIn=payRep.forPay();
		moneyOut=cashRep.get();
		//TODO  choose the valid records(inside the time period ~~)
		for(int i=0;i<moneyIn.size();i++){
//			if(moneyIn.get(i).time<startTime||moneyIn.get(i).time>endTime){
//				moneyIn.remove(i);
//			    i--;
//			}
		}
		BusinessFormVO vo =new BusinessFormVO(startTime, endTime, moneyIn,moneyOut);
		return vo;
		
		
	}
	public Boolean save(BusinessFormVO vo) {
		try {
			busiFormdata.add(vo.toPO(vo));
		} catch (RemoteException e) {
		}
		return true;
	}

}
