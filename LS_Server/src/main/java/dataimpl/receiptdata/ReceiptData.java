package dataimpl.receiptdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import PO.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import datautil.DataUtility;
import util.enumData.*;

public class ReceiptData implements ReceiptDataService{
	public String chooseAdd(Rep rep){
		switch (rep) {
		case CashRep:
			return null;
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
	
	public ResultMessage submit(ReceiptPO po, Rep rep) throws IOException {
		return util.save(po, chooseAdd(rep));
	}

	public ResultMessage save(ReceiptPO po, Rep rep) throws IOException {
		return util.save(po, chooseAdd(rep));
	}

	public ArrayList<ReceiptPO> getAllRep(Rep rep) throws ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<Object> objects = util.getAll(chooseAdd(rep));
 		for(Object object : objects){
 			receiptPOs.add((ReceiptPO)object);
 		}
 		return receiptPOs;
	}

	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep) throws ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		ArrayList<ReceiptPO> dateReceiptPOs = new ArrayList<ReceiptPO>();
		for(ReceiptPO receiptPO : receiptPOs){
			if(receiptPO.getDate().equals(date))
				dateReceiptPOs.add(receiptPO);
		}
		return dateReceiptPOs;
	}

	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException {
		File saveFile = new File(chooseAdd(rep));
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

	public ResultMessage delete(int n, Rep rep) throws ClassNotFoundException, IOException {
		return util.delete(n, chooseAdd(rep));
	}

	public ResultMessage delete(String num, Rep rep) throws ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(rep);
		util.clear(chooseAdd(rep));
		ReceiptPO po;
		for(int i = 0;i<receiptPOs.size();i++){
			po = receiptPOs.get(i);
			if(!po.getNum().equals(num))
				save(po, rep);
		}
		return ResultMessage.SUCCESS;
	}
	
	public String createNum(String date, Rep rep) throws ClassNotFoundException, IOException{
		ArrayList<ReceiptPO> receiptPOs = getRepByDate(date, rep);
		return receiptPOs.size()+1+"";
	}
	
	class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			return;
		}
	}

}
