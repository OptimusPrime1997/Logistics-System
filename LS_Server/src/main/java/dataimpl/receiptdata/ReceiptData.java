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
			return "data/ReceiptSubmitData/CashRepSubmit.txt";
		case ShipmentRep:
			return "data/ReceiptSubmitData/ShipmentRepSubmit.txt";
		case GetRep:
			return "data/ReceiptSubmitData/GetRepSubmit.txt";
		case DeliverRep:
			return "data/ReceiptSubmitData/DeliverRepSubmit.txt";
		case PayRep:
			return "data/ReceiptSubmitData/PayRepSubmit.txt";
		case InStockRep:
			return "data/ReceiptSubmitData/InStockRepSubmit.txt";
		case OutStockRep:
			return "data/ReceiptSubmitData/OutStockRepSubmit.txt";
		case ShippingRep:
			return "data/ReceiptSubmitData/ShippingRepSubmit.txt";
		case ReceptionRep:
			return "data/ReceiptSubmitData/ReceptionRepSubmit.txt";
		case TransferRep:
			return "data/ReceiptSubmitData/TransferRepSubmit.txt";
		case PayRepBonus:
			return "data/ReceiptSubmitData/PayRepBonusSubmit.txt";
		case PayRepCourierSalary:
			return "data/ReceiptSubmitData/PayRepCourierSalarySubmit.txt";
		case PayRepDriverSalary:
			return "data/ReceiptSubmitData/PayRepDriverSalarySubmit.txt";
		case PayRepFreight:
			return "data/ReceiptSubmitData/PayRepFreightSubmit.txt";
		case PayRepRefund:
			return "data/ReceiptSubmitData/PayRepRefundSubmit.txt";
		case PayRepRent:
			return "data/ReceiptSubmitData/PayRepRentSubmit.txt";
		case PayRepStaffSalary:
			return "data/ReceiptSubmitData/PayRepStaffSalarySubmit.txt";
		default:
			return null;
		}
	}
	
	public String chooseSaveAdd(Rep rep){
		switch (rep) {
		case CashRep:
			return "data/ReceiptSaveData/CashRepSave.txt";
		case ShipmentRep:
			return "data/ReceiptSaveData/ShipmentRepSave.txt";
		case GetRep:
			return "data/ReceiptSaveData/GetRepSave.txt";
		case DeliverRep:
			return "data/ReceiptSaveData/DeliverRepSave.txt";
		case PayRep:
			return "data/ReceiptSaveData/PayRepSave.txt";
		case InStockRep:
			return "data/ReceiptSaveData/InStockRepSave.txt";
		case OutStockRep:
			return "data/ReceiptSaveData/OutStockRepSave.txt";
		case ShippingRep:
			return "data/ReceiptSaveData/ShippingRepSave.txt";
		case ReceptionRep:
			return "data/ReceiptSaveData/ReceptionRepSave.txt";
		case TransferRep:
			return "data/ReceiptSaveData/TransferRepSave.txt";
		case PayRepBonus:
			return "data/ReceiptSaveData/PayRepBonusSave.txt";
		case PayRepCourierSalary:
			return "data/ReceiptSaveData/PayRepCourierSalarySave.txt";
		case PayRepDriverSalary:
			return "data/ReceiptSaveData/PayRepDriverSalarySave.txt";
		case PayRepFreight:
			return "data/ReceiptSaveData/PayRepFreightSave.txt";
		case PayRepRefund:
			return "data/ReceiptSaveData/PayRepRefundSave.txt";
		case PayRepRent:
			return "data/ReceiptSaveData/PayRepRentSave.txt";
		case PayRepStaffSalary:
			return "data/ReceiptSaveData/PayRepStaffSalarySave.txt";
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
