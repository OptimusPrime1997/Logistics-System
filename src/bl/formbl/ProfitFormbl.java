package bl.formbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.DataFactory;
import VO.CashRepVO;
import VO.PayRepVO;
import VO.ProfitFormVO;
import bl.receiptbl.CashRepblImpl;
import bl.receiptbl.PayRepblImpl;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	ProfitFormDataService profitFormData=DataFactory.getProfitFormdata();
	
	public ProfitFormVO show() {
		PayRepblImpl payRep=new PayRepblImpl();
		CashRepblImpl cashRep=new CashRepblImpl();
		ArrayList<PayRepVO> moneyIn=payRep.forPay();
		ArrayList<CashRepVO> moneyOut=cashRep.get();
		
		//TODO   calculate totalIn&totalOut with the moneyIn&moneyOut
		double totalIn=0,totalOut=0,totalProfit=0;
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
