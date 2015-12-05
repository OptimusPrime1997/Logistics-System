package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.ResultMessage;
import VO.ProfitFormVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.PayRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	
	public ProfitFormVO show() throws NotBoundException, ClassNotFoundException, IOException {
		double totalIn=0,totalOut=0,totalProfit=0;
		
		PayRepbl payRep=new PayRepbl();
		CashRepbl cashRep=new CashRepbl();
		ArrayList<PayRepVO> moneyOut = payRep.getAllRep();
		ArrayList<CashVO> moneyIn = null;//TODO cashRep.getAllRep();
		for(int i=0;i<moneyIn.size();i++){
			totalIn+=moneyIn.get(i).money;
		}
		for(int i=0;i<moneyOut.size();i++){			
//			for(int j=0;j<moneyOut.get(i).salary.size();j++){
//				totalOut+=moneyOut.get(i).salary.get(j).money;
//			}
//			for(int j=0;j<moneyOut.get(i).littleThing.size();j++){
//				totalOut+=moneyOut.get(i).littleThing.get(j).money;
//			}
//			for(int j=0;j<moneyOut.get(i).rent.size();j++){
//				totalOut+=moneyOut.get(i).rent.get(j).money;
//			}
//			for(int j=0;j<moneyOut.get(i).transferPay.size();j++){
//				totalOut+=moneyOut.get(i).transferPay.get(j).money;
//			}
		}
		totalProfit=totalIn-totalOut;
	    ProfitFormVO vo = new ProfitFormVO(CurrentTime.getTime(), totalOut, totalIn, totalProfit);
		return vo;
	}

	public ResultMessage save(ProfitFormVO vo) {
		try {
			return getPFormData().add(vo.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
		
	}
	private ProfitFormDataService getPFormData(){
		ProfitFormDataService service=null;
		try {
			service=(ProfitFormDataService)Naming.lookup("profit");
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
