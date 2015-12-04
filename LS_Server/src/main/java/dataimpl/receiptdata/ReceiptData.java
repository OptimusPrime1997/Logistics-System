package dataimpl.receiptdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import datautil.DataUtility;
import util.enumData.*;

public class ReceiptData extends UnicastRemoteObject implements ReceiptDataService{
	public ReceiptData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4116800219997834632L;

	public String chooseSubmitAdd(Rep rep){
		switch (rep) {
		case CashRep:
			return "/Users/apple/Desktop/Logistics-System/LS_Server/submit.txt";
		case ShipmentRep:
			return null;
		case GetRep:
			return null;
		case DeliverRep:
			return null;
		case PayRep:
			return null;
		case InStockRep:
			return null;
		case OutStockRep:
			return null;
		case ShippingRep:
			return null;
		case ReceptionRep:
			return null;
		case TransferRep:
			return null;
		default:
			return null;
		}
	}
	
	public String chooseSaveAdd(Rep rep){
		switch (rep) {
		case CashRep:
			return "/Users/apple/Desktop/Logistics-System/LS_Server/submit.txt";
		case ShipmentRep:
			return null;
		case GetRep:
			return null;
		case DeliverRep:
			return null;
		case PayRep:
			return null;
		case InStockRep:
			return null;
		case OutStockRep:
			return null;
		case ShippingRep:
			return null;
		case ReceptionRep:
			return null;
		case TransferRep:
			return null;
		default:
			return null;
		}
	}
	
	DataUtility util = new DataUtility();
	
	public void submit(ReceiptPO po, Rep rep) throws IOException, RemoteException {
		util.save(po, chooseSubmitAdd(rep));
	}

	public void save(ReceiptPO po, Rep rep) throws IOException, RemoteException {
		util.save(po, chooseSaveAdd(rep));
	}

	public ArrayList<ReceiptPO> getAllRep(Rep rep) throws ClassNotFoundException, IOException , RemoteException{
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<Object> objects = util.getAll(chooseSaveAdd(rep));
		if(objects==null)
			return null;
 		for(Object object : objects){
 			receiptPOs.add((ReceiptPO)object);
 		}
 		return receiptPOs;
	}

	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> dateReceiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		if(receiptPOs==null)
			return null;
		for(ReceiptPO receiptPO : receiptPOs){
			if(receiptPO.getDate().equals(date))
				dateReceiptPOs.add(receiptPO);
		}
		return dateReceiptPOs;
	}

	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException, RemoteException {
		File saveFile = new File(chooseSaveAdd(rep));
		ReceiptPO po = null;
			FileInputStream fin = new FileInputStream(saveFile);
			ObjectInputStream is = new ObjectInputStream(fin);
			while (fin.available() > 0) {
				po = (ReceiptPO)is.readObject();
				if(po.getNum().equals(num))
					return po;
			}
		return po;
	}

	public void delete(int n, Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		util.delete(n, chooseSaveAdd(rep));
	}

	public void delete(String num, Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		util.clear(chooseSaveAdd(rep));
		ReceiptPO po;
		for(int i = 0;i<receiptPOs.size();i++){
			po = receiptPOs.get(i);
			if(!po.getNum().equals(num))
				save(po, rep);
		}
	}
	
	public String createNum(String date, Rep rep) throws ClassNotFoundException, IOException, RemoteException{
		ArrayList<ReceiptPO> receiptPOs = getRepByDate(date, rep);
		return receiptPOs.size()+1+"";
	}
	
	public void clearSubmit(Rep rep) throws IOException{
		util.clear(chooseSubmitAdd(rep));
	}
	
	public void clearSave(Rep rep) throws IOException{
		util.clear(chooseSaveAdd(rep));
	}
	
	class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream out) throws IOException, RemoteException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException, RemoteException {
			return;
		}
	}

}
