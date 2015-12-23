package dataimpl.receiptdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import dataservice.receiptdataservice.TransferRepDataService;
import datautil.DataUtility;

public class TransferRepData extends UnicastRemoteObject implements TransferRepDataService{

	public TransferRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2724104235816248004L;
	
	private DataUtility util = new DataUtility();
	
	private String getAdd() {
		return "data/ReceiptSaveData/PayRepSave.txt";
	}
	
	private String yyyymmInDate(String date){
		String[] strings = date.split("-");
		return strings[0] + strings[1];
	}

	@Override
	public ArrayList<ReceiptPO> getMonthRep(String date) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Object> objects = util.getAll(getAdd());
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		if (objects == null)
			return null;
		for(Object object : objects){
			ReceiptPO receiptPO = (ReceiptPO)object;
			String s = yyyymmInDate(receiptPO.getDate());
			String c = yyyymmInDate(date);
			if(s.equals(c))
				receiptPOs.add(receiptPO);
		}
		return receiptPOs;
	}


}
