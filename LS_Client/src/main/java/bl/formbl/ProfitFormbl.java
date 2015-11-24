package bl.formbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import VO.CashRepVO;
import VO.PayRepVO;
import VO.ProfitFormVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	ProfitFormDataService profitFormData;
	
	public ProfitFormVO show() {
		double totalIn=0,totalOut=0,totalProfit=0;
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		ArrayList<PayRepVO> moneyOut = payRep.getAllPayRep();
		ArrayList<CashRepVO> moneyIn = cashRep.getAllRep();
		for(int i=0;i<moneyIn.size();i++){
			totalIn+=moneyIn.get(i).money;
		}
		for(int i=0;i<moneyOut.size();i++){			
			for(int j=0;j<moneyOut.get(i).salary.size();j++){
				totalOut+=moneyOut.get(i).salary.get(j).money;
			}
			for(int j=0;j<moneyOut.get(i).littleThing.size();j++){
				totalOut+=moneyOut.get(i).littleThing.get(j).money;
			}
			for(int j=0;j<moneyOut.get(i).rent.size();j++){
				totalOut+=moneyOut.get(i).rent.get(j).money;
			}
			for(int j=0;j<moneyOut.get(i).transferPay.size();j++){
				totalOut+=moneyOut.get(i).transferPay.get(j).money;
			}
		}
		totalProfit=totalIn-totalOut;
	    ProfitFormVO vo = new ProfitFormVO(CurrentTime.getTime(), totalOut, totalIn, totalProfit);
		return vo;
	}

	public Boolean save(ProfitFormVO vo) {
		try {
			profitFormData.add(vo.toPO(vo));
		} catch (RemoteException e) {
		}
		return true;
	}

}
