package bl.formbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.BusinessFormVO;
import VO.CashRepVO;
import VO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepController;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepController;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;

public class BusinessFormbl {
	BusinessFormDataService busiFormdata;
	
	public BusinessFormVO show(String startTime, String endTime) {
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		ArrayList<PayRepVO> moneyOut = payRep.getAllPayRep();
		ArrayList<CashRepVO> moneyIn = cashRep.getAllRep();
		//TODO  choose the valid records(inside the time period ~~)
		for(int i=0;i<moneyIn.size();i++){
//			if(moneyIn.get(i).time<startTime||moneyIn.get(i).time>endTime){
//				moneyIn.remove(i);
//			    i--;
//			}
		}
		BusinessFormVO vo =new BusinessFormVO(startTime, endTime, moneyOut, moneyIn);
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
