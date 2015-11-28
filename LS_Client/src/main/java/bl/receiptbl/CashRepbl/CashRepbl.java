package bl.receiptbl.CashRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import util.enumData.Rep;
import util.enumData.ResultMessage;
import PO.CashRepPO;
import PO.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.CashRepVO;
import VO.GoodsVO;
import VO.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.managementbl.accountbl.Accountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import dataservice.receiptdataservice.CashRepDataService;
import Exception.*;

public class CashRepbl{
	Goodsbl goodsbl = new Goodsbl();
	Accountbl accountbl = new Accountbl();
	Test test = new Test();
	Receiptbl receiptbl = new Receiptbl();
	
	public ResultMessage checkCourierNum(String courierNum){
		if(courierNum.length()<11)
			return ResultMessage.REPNUM_LENGTH_LACKING;
		else if(courierNum.length()>11)
			return ResultMessage.REPNUM_LENGTH_OVER;
		else if(!courierNum.substring(6, 8).equals("06"))
			return ResultMessage.REPNUM_NOT_RIGHT;
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage checkCashRep(CashRepVO vo){
		if(vo.courierNum==null)
			return ResultMessage.NOT_COMPLETED;
		return ResultMessage.SUCCESS;
	}
	
	public String getCourierName(String courierNum) throws NameNotFoundException, RemoteException{
//		return accountbl.findByNum(courierNum).accountName;
		return test.findByNum(courierNum).accountName;
	}
	
	public ArrayList<GoodsVO> getGoods(String courierNum, String date){
		return goodsbl.getGoodsByGetCourier(courierNum,date);
	}
	
	public double getMoneySum(ArrayList<GoodsVO> arrGoods){
		double moneysum = 0;
		for(int i = 0;i<arrGoods.size();++i){
        	moneysum += arrGoods.get(i).moneyTotal;
    	}
		return moneysum;
	}
	
	public ResultMessage submit(ReceiptVO vo) throws NotBoundException, IOException{
		return receiptbl.submit(CashRepVO.toPO((CashRepVO)vo), Rep.CashRep);
	}
	
	public ArrayList<CashRepVO> getAllRep() throws NotBoundException, ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.CashRep);
		return toArrayVO(receiptPOs);
	}
	
	public ArrayList<CashRepVO> getRepByDate(String date) throws NotBoundException, ClassNotFoundException, IOException{
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.CashRep);
		return toArrayVO(receiptPOs);
	}
	
	public CashRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException{
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.CashRep);
		return new CashRepVO((CashRepPO)receiptPO);
	}
	
	public ResultMessage delete(int n) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.delete(n, Rep.CashRep);
	}

	public ResultMessage delete(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.delete(num, Rep.CashRep);
	} 
	
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException{
		return receiptbl.createNum(date, Rep.CashRep);
	}
	
	public Vector<Object> initTable(String date) throws NotBoundException, ClassNotFoundException, IOException{
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
	
	public static ArrayList<CashRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs){
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		for(ReceiptPO receiptPO : receiptPOs)
			cashRepVOs.add(new CashRepVO((CashRepPO)receiptPO));
		return cashRepVOs;
	}
	
}
