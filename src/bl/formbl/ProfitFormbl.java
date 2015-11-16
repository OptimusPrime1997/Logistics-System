package bl.formbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.DataFactory;
import VO.CashRepVO;
import VO.PayRepVO;
import VO.ProfitFormVO;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	ProfitFormDataService profitFormData=DataFactory.getProfitFormdata();
	
	public ProfitFormVO show() {
		double totalIn=0,totalOut=0,totalProfit=0;
		MockPayRep payRep=new MockPayRep();
		MockCashRep cashRep=new MockCashRep();
		ArrayList<PayRepVO> moneyOut=payRep.get();
		ArrayList<CashRepVO> moneyIn=cashRep.get();
		for(int i=0;i<moneyIn.size();i++){
			totalIn+=moneyIn.get(i).money;
		}
		//TODO   calculate totalOut with the moneyIn&moneyOut
		
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
