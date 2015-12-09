package dataimpl.receiptdata;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import datautil.DataUtility;
import util.enumData.*;

public class ReceiptData extends UnicastRemoteObject implements ReceiptDataService {
	public ReceiptData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4116800219997834632L;

	public String submitAdd(Rep rep) {
		return "data/ReceiptSubmitData/" + rep + "Submit.txt";
	}

	public String saveAdd(Rep rep) {
		return "data/ReceiptSaveData/" + rep + "Save.txt";
	}

	DataUtility util = new DataUtility();

	public void submit(ReceiptPO po, Rep rep) throws IOException, RemoteException {
		util.save(po, submitAdd(rep));
	}

	public void save(ReceiptPO po, Rep rep) throws IOException, RemoteException {
		util.save(po, saveAdd(rep));
	}

	public ArrayList<ReceiptPO> getAllRep(Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<Object> objects = util.getAll(saveAdd(rep));
		if (objects == null)
			return null;
		for (Object object : objects) {
			receiptPOs.add((ReceiptPO) object);
		}
		return receiptPOs;
	}

	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep)
			throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> dateReceiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		if (receiptPOs == null)
			return null;
		for (ReceiptPO receiptPO : receiptPOs) {
			if (receiptPO.getDate().equals(date))
				dateReceiptPOs.add(receiptPO);
		}
		return dateReceiptPOs;
	}

	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		if (receiptPOs == null)
			return null;
		for(ReceiptPO receiptPO : receiptPOs){
			if(receiptPO.getNum().equals(num))
				return receiptPO;
		}
		return null;
	}

	public void delete(int n, Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		util.delete(n, saveAdd(rep));
	}

	public void delete(String num, Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		util.clear(saveAdd(rep));
		ReceiptPO po;
		for (int i = 0; i < receiptPOs.size(); i++) {
			po = receiptPOs.get(i);
			if (!po.getNum().equals(num))
				save(po, rep);
		}
	}

	public String createNum(String date, Rep rep) throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getRepByDate(date, rep);
		if (receiptPOs == null)
			return 1 + "";
		return receiptPOs.size() + 1 + "";
	}

	public void clearSubmit(Rep rep) throws IOException {
		util.clear(submitAdd(rep));
	}

	public void clearSave(Rep rep) throws IOException {
		util.clear(saveAdd(rep));
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
