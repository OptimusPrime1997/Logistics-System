package dataimpl.receiptdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import dataservice.receiptdataservice.OutStockRepDataService;
import datautil.DataUtility;

public class OutStockRepData extends UnicastRemoteObject implements OutStockRepDataService{

	public OutStockRepData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 733096741429864593L;
	
private DataUtility util = new DataUtility();
	
	private String getAdd(){
		return "data/ReceiptSubmitData/OutStockRepSubmit.txt";
	}

	@Override
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		ArrayList<Object> objects = util.getAll(getAdd());
		ArrayList<ReceiptPO> outStockRepPOs = new ArrayList<ReceiptPO>();
		if (objects == null)
			return null;
		for(Object object : objects){
			ReceiptPO receiptPO = (ReceiptPO)object;
			String mmdd = receiptPO.getDate();
			if(mmdd.substring(5).equals(date))
				outStockRepPOs.add(receiptPO);
		}
		return outStockRepPOs;
	}

}
