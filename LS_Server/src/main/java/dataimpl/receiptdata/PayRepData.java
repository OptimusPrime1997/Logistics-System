package dataimpl.receiptdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.Receipt.PayRepPO;
import PO.Receipt.ReceiptPO;
import dataservice.receiptdataservice.PayRepDataService;
import datautil.DataUtility;

public class PayRepData extends UnicastRemoteObject implements PayRepDataService{

	public PayRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6098610579749335008L;
	
	private DataUtility util = new DataUtility();
	
	private String getSubmitAdd() {
		return "data/ReceiptSubmitData/PayRepSubmit.txt";
	}
	
	private String getSaveAdd() {
		return "data/ReceiptSaveData/PayRepSave.txt";
	}

	public PayRepPO getSubmitPayRep() throws ClassNotFoundException, IOException{
		ArrayList<Object> objects = util.getAll(getSubmitAdd());
		if (objects == null)
			return null;
		ReceiptPO receiptPO = (ReceiptPO)objects.get(0);
		return (PayRepPO)receiptPO;
	}
	
	public void clearPaySubmit() throws IOException{
		util.clear(getSubmitAdd());
	}
	
	public ArrayList<PayRepPO> getAllPayRep() throws ClassNotFoundException, IOException{
		ArrayList<PayRepPO> payRepPOs = new ArrayList<PayRepPO>();
		ArrayList<Object> objects = util.getAll(getSaveAdd());
		if (objects == null)
			return null;
		for (Object object : objects) {
			PayRepPO payRepPO = (PayRepPO) object;
			payRepPOs.add(payRepPO);
		}
		return payRepPOs;
	}
	
	public PayRepPO getPayRepByNum(String num) throws ClassNotFoundException, IOException{
		ArrayList<Object> objects = util.getAll(getSaveAdd());
		if (objects == null)
			return null;
		for(Object object : objects){
			PayRepPO payRepPO = (PayRepPO) object;
			if(payRepPO.getNum().equals(num))
				return payRepPO;
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		PayRepData payRepData = new PayRepData();
		payRepData.getPayRepByNum("201512");
	}
	
}
