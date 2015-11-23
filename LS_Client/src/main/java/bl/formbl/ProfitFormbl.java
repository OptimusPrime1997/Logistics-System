package bl.formbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.DataFactory;
import VO.CashRepVO;
import VO.PayRepVO;
import VO.PayRepVO.Salary;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import VO.ProfitFormVO;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	ProfitFormDataService profitFormData;
	
	public ProfitFormVO show() {
		double totalIn=0,totalOut=0,totalProfit=0;
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		ArrayList<PayRepVO> moneyOut = payRep.getAllPayRep();
		ArrayList<CashRepVO> moneyIn = cashRep.getAllCashRep();
		for(int i=0;i<moneyIn.size();i++){
			totalIn+=moneyIn.get(i).money;
		}
		for(int i=0;i<moneyOut.size();i++){			
			for(int j=0;j<moneyOut.get(i).Salarys.size();j++){
				totalOut+=moneyOut.get(i).Salarys.get(j).money;
			}
			for(int j=0;j<moneyOut.get(i).littleThings.size();j++){
				totalOut+=moneyOut.get(i).littleThings.get(j).money;
			}
			for(int j=0;j<moneyOut.get(i).rents.size();j++){
				totalOut+=moneyOut.get(i).rents.get(j).money;
			}
			for(int j=0;j<moneyOut.get(i).TransferPays.size();j++){
				totalOut+=moneyOut.get(i).TransferPays.get(j).money;
			}
		}
		totalProfit=totalIn-totalOut;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    ProfitFormVO vo = new ProfitFormVO(df.format(new Date()), totalOut, totalIn, totalProfit);
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
