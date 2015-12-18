package dataimpl.receiptdata;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
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

	public String getOffice(String num) {
		if (num.substring(2, 5).equals("000"))
			return num.substring(2, 5);
		return num.substring(0, 5);
	}

	public String submitAdd(Rep rep) {
		return "data/ReceiptSubmitData/" + rep + "Submit.txt";
	}

	public String saveAdd(Rep rep) {
		return "data/ReceiptSaveData/" + rep + "Save.txt";
	}

	private DataUtility util = new DataUtility();

	public void submit(ReceiptPO po, Rep rep) throws IOException, RemoteException {
		util.save(po, submitAdd(rep));
	}

	public void save(ReceiptPO po, Rep rep) throws IOException, RemoteException {
		util.save(po, saveAdd(rep));
	}

	public ArrayList<ReceiptPO> getAllRep(Rep rep, String office)
			throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<Object> objects = util.getAll(saveAdd(rep));
		if (objects == null)
			return null;
		for (Object object : objects) {
			ReceiptPO receiptPO = (ReceiptPO) object;
			if (getOffice(receiptPO.getNum()).equals(office))
				receiptPOs.add(receiptPO);
		}
		return receiptPOs;
	}

	public ReceiptPO getSubmitRep(Rep rep, String office) throws ClassNotFoundException, IOException {
		ArrayList<Object> objects = util.getAll(submitAdd(rep));
		if (objects == null)
			return null;
		ReceiptPO receiptPO = null;
		for (Object object : objects) {
			receiptPO = (ReceiptPO) object;
			if (getOffice(receiptPO.getNum()).equals(office))
				break;
		}
		return receiptPO;

	}

	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep, String office)
			throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> dateReceiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep, office);
		if (receiptPOs == null)
			return null;
		for (ReceiptPO receiptPO : receiptPOs) {
			if (receiptPO.getDate().equals(date))
				dateReceiptPOs.add(receiptPO);
		}
		return dateReceiptPOs;
	}

	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep, getOffice(num));
		if (receiptPOs == null)
			return null;
		for (ReceiptPO receiptPO : receiptPOs) {
			if (receiptPO.getNum().equals(num))
				return receiptPO;
		}
		return null;
	}

	public String createNum(String date, Rep rep, String office)
			throws ClassNotFoundException, IOException, RemoteException {
		ArrayList<ReceiptPO> receiptPOs = getRepByDate(date, rep, office);
		if (receiptPOs == null)
			return 1 + "";
		String s = receiptPOs.size() + 1 + "";
		for(int i = s.length();i < 4;i++){
			s = "0" + s;
		}
		return s;
	}

	public void clearSubmit(Rep rep, String office) throws IOException, ClassNotFoundException {
		ArrayList<Object> objects = util.getAll(submitAdd(rep));
		util.clear(submitAdd(rep));
		ReceiptPO receiptPO = null;
		for (Object object : objects) {
			receiptPO = (ReceiptPO) object;
			if (!getOffice(receiptPO.getNum()).equals(office))
				save(receiptPO, rep);
		}
	}

	public void clearSave(Rep rep, String office) throws IOException, ClassNotFoundException {
		ArrayList<Object> objects = util.getAll(saveAdd(rep));
		util.clear(saveAdd(rep));
		ReceiptPO receiptPO = null;
		for (Object object : objects) {
			receiptPO = (ReceiptPO) object;
			if (!getOffice(receiptPO.getNum()).equals(office))
				save(receiptPO, rep);
		}
	}
	
	@Override
	public ArrayList<ReceiptPO> forCheck(Rep rep) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Object> objects = util.getAll(submitAdd(rep));
		if(objects==null)
			return null;
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		for(Object object : objects){
			receiptPOs.add((ReceiptPO) object);
		}
		return receiptPOs;
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
