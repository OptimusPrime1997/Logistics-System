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
import dataservice.receiptdataservice.CashRepDataService;
import util.Excetion.*;

public class CashRepbl{
	ReceiptClient client = new ReceiptClient();
	Goodsbl goodsbl = new Goodsbl();
	Accountbl accountbl = new Accountbl();
	
	public CashRepDataService getCashRepDataService() throws RemoteException{
		CashRepDataService cashRepDataService = null;
			cashRepDataService = client.getCashRepDataService();
		return cashRepDataService;
	}
	
	public ResultMessage submit(CashRepVO vo) throws RemoteException{
		ResultMessage message = checkCashRep(vo);
		if(message==ResultMessage.SUCCESS)
			return getCashRepDataService().submit(CashRepVO.toPO(vo));
		else
			return message;
	}
	
	public String getCourierName(String courierNum) throws NameNotFoundException, RemoteException{
		ResultMessage message = checkCourierNum(courierNum);
		if(message==ResultMessage.SUCCESS)
			return accountbl.findByNum(courierNum).accountName;
		else
			throw new NameNotFoundException();
	}
	
	private ResultMessage checkCourierNum(String courierNum){
		if(courierNum.length()<11)
			return ResultMessage.REPNUM_LENGTH_LACKING;
		else if(courierNum.length()>11)
			return ResultMessage.REPNUM_LENGTH_OVER;
		else if(!courierNum.substring(6, 8).equals("06"))
			return ResultMessage.REPNUM_NOT_RIGHT;
		return ResultMessage.SUCCESS;
	}
	
	private ResultMessage checkCashRep(CashRepVO vo){
		if(vo.courierNum==null)
			return ResultMessage.NOT_COMPLETED;
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage delete(int n) throws RemoteException {
		// TODO Auto-generated method stub
		return getCashRepDataService().delete(n);
	}

	public ResultMessage delete(String num) throws RemoteException {
		// TODO Auto-generated method stub
		return getCashRepDataService().delete(num);
	} 
	
	public String createNum(String date) throws RemoteException{
		return getCashRepDataService().createNum(date);
	}
	
	public ArrayList<CashRepVO> getAllRep() throws RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getCashRepDataService().getAllRep();
		return toArrayVO(receiptPOs);
	}
	
	public ArrayList<CashRepVO> getRepByDate(String date) throws RemoteException{
		ArrayList<ReceiptPO> receiptPOs = getCashRepDataService().getRepByDate(date);
		return toArrayVO(receiptPOs);
	}
	
	public CashRepVO getRepByNum(String num) throws RemoteException{
		ReceiptPO receiptPO = getCashRepDataService().getRepByNum(num);
		return new CashRepVO((CashRepPO)receiptPO);
	}

	public ArrayList<GoodsVO> getGoods(String courierNum){
		return goodsbl.getGoodsByGetCourier(courierNum);
	}
	
	public double getMoneySum(ArrayList<GoodsVO> arrGoods){
		double moneysum = 0;
		for(int i = 0;i<arrGoods.size();++i){
        	moneysum += arrGoods.get(i).moneyTotal;
    	}
		return moneysum;
	}
	
	public Vector<Object> initTable(String date) throws RemoteException{
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
