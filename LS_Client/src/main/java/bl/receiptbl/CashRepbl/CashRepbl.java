package bl.receiptbl.CashRepbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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
import dataservice.receiptdataservice.CashRepDataService;
import Exception.*;

public class CashRepbl{
	ReceiptClient client = new ReceiptClient();
	Goodsbl goodsbl = new Goodsbl();
	Accountbl accountbl = new Accountbl();
	Test test = new Test();
	private static CashRepDataService cashRepDataService = null;
	
	public CashRepDataService getCashRepDataService() throws RemoteException, MalformedURLException, NotBoundException{
		if(cashRepDataService==null)
			cashRepDataService = client.getCashRepDataService();
		return cashRepDataService;
	}
	
	public ResultMessage submit(CashRepVO vo) throws RemoteException, MalformedURLException, NotBoundException{
		return getCashRepDataService().submit(CashRepVO.toPO(vo));
	}
	
	public String getCourierName(String courierNum) throws NameNotFoundException, RemoteException{
//		return accountbl.findByNum(courierNum).accountName;
		return test.findByNum(courierNum).accountName;
	}
	
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
	
	public ResultMessage delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return getCashRepDataService().delete(n);
	}

	public ResultMessage delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return getCashRepDataService().delete(num);
	} 
	
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException{
		return getCashRepDataService().createNum(date);
	}
	
	public ArrayList<CashRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		ArrayList<ReceiptPO> receiptPOs = getCashRepDataService().getAllRep();
		return toArrayVO(receiptPOs);
	}
	
	public ArrayList<CashRepVO> getRepByDate(String date) throws RemoteException, MalformedURLException, NotBoundException{
		ArrayList<ReceiptPO> receiptPOs = getCashRepDataService().getRepByDate(date);
		return toArrayVO(receiptPOs);
	}
	
	public CashRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException{
		ReceiptPO receiptPO = getCashRepDataService().getRepByNum(num);
		return new CashRepVO((CashRepPO)receiptPO);
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
	
	public Vector<Object> initTable(String date) throws RemoteException, MalformedURLException, NotBoundException{
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
