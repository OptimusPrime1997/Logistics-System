package bl.formbl;

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
	PayRepblImpl payRep=new PayRepblImpl();
	CashRepblImpl cashRep=new CashRepblImpl();
	public ProfitFormVO show() {
		ArrayList<PayRepVO> moneyIn=payRep.forPay();
		ArrayList<CashRepVO> moneyOut=cashRep.get();
		
		//TODO   calculate totalIn&totalOut with the moneyIn&moneyOut
		double totalIn=0,totalOut=0,totalProfit=0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	    ProfitFormVO vo = new ProfitFormVO(df.format(new Date()), totalOut, totalIn, totalProfit);
		return vo;
	}

	public Boolean save(ProfitFormVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
