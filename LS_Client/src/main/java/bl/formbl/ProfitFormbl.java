package bl.formbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.ResultMessage;
import RMIClient.FormClient;
import VO.CashRepVO;
import VO.PayRepVO;
import VO.ProfitFormVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.PayRepbl.PayRepbl;
import dataservice.formdataservice.BusinessFormDataService;
import dataservice.formdataservice.ProfitFormDataService;

public class ProfitFormbl {
	
	public ProfitFormVO show() throws RemoteException {
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

	public ResultMessage save(ProfitFormVO vo) {
		try {
			return getPFormData().add(vo.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
		
	}
	private FormClient client=new FormClient();
	private ProfitFormDataService getPFormData(){
		ProfitFormDataService service=null;
		try {
			service=client.getProfitFormDataService();
		} catch (RemoteException e) {
		}
		return service;
	}

}
