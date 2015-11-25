package bl.receiptbl.CashRepbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import util.enumData.ResultMessage;
import PO.CashRepPO;
import PO.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.CashRepVO;
import VO.GoodsVO;
import bl.goodsbl.Goodsbl;
import bl.managementbl.accountbl.Accountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import dataservice.receiptdataservice.CashRepDataService;

public class CashRepbl{
	ReceiptClient client = new ReceiptClient();
	Goodsbl goodsbl = new Goodsbl();
	Accountbl accountbl = new Accountbl();
	Receiptbl receiptbl = new Receiptbl();
	
	
	public CashRepDataService getCashRepDataService(){
		CashRepDataService cashRepDataService = null;
		try {
			cashRepDataService = client.getCashRepDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cashRepDataService;
	}
	
	public ResultMessage submit(CashRepVO vo){
		return getCashRepDataService().submit(CashRepVO.toPO(vo));
	}
	
	public ResultMessage delete(int n) {
		// TODO Auto-generated method stub
		return getCashRepDataService().delete(n);
	}

	public ResultMessage delete(String num) {
		// TODO Auto-generated method stub
		return getCashRepDataService().delete(num);
	} 
	
	public String createNum(String date){
		return getCashRepDataService().createNum(date);
	}
	
	public ArrayList<CashRepVO> getAllRep() {
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		ArrayList<ReceiptPO> receiptPOs = getCashRepDataService().getAllRep();
		for(int i = 0;i<receiptPOs.size();i++){
			cashRepVOs.add(new CashRepVO((CashRepPO)receiptPOs.get(i)));
		}
		return cashRepVOs;
	}
	
	public ArrayList<CashRepVO> getRepByDate(String date){
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		ArrayList<ReceiptPO> receiptPOs = getCashRepDataService().getRepByDate(date);
		for(int i = 0;i<receiptPOs.size();i++){
			cashRepVOs.add(new CashRepVO((CashRepPO)receiptPOs.get(i)));
		}
		return cashRepVOs;
	}
	
	public CashRepVO getRepByNum(String num){
		ReceiptPO receiptPO = getCashRepDataService().getRepByNum(num);
		return new CashRepVO((CashRepPO)receiptPO);
	}

	public ArrayList<GoodsVO> getGoods(String courierNum){
		return goodsbl.getGoodsByGetCourier(courierNum);
	}
	
	public String getCourierName(String courierNum){
		return accountbl.findByNum(courierNum).accountName;
	}
	
	public double getMoneySum(ArrayList<GoodsVO> arrGoods){
		double moneysum = 0;
		for(int i = 0;i<arrGoods.size();++i){
        	moneysum += arrGoods.get(i).moneyTotal;
    	}
		return moneysum;
	}
	
	public Vector<Object> initTable(String date){
		 Vector<Object> arr = new Vector<Object>();
		 Vector<Object> data = new Vector<Object>();
		 ArrayList<CashRepVO> receiptVOs = getRepByDate(date);
		 CashRepVO cashRep;
		 if(receiptVOs.size()==0){
			 arr.add(null);
			 arr.add(null);
			 arr.add(null);
			 arr.add(null);
			 data.add(arr);
		 }
		 else {
			 for(int i = 0;i<receiptVOs.size();i++){
				 cashRep = receiptVOs.get(i);
				 arr.add(cashRep.courierNum);
				 arr.add(cashRep.courierName);
				 arr.add(cashRep.money);
				 arr.add(null);
				 data.add(arr);
			 }
			 
		 }
		 return data;
	}
	
}
