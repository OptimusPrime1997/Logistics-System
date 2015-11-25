package dataimpl.receiptdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import PO.ReceiptPO;
import datautil.DataUtility;
import util.enumData.*;

public class ReceiptData {
	
	DataUtility util = new DataUtility();

	public ResultMessage submit(ReceiptPO po, String add) {
		return util.save(po, add);
	}

	public ResultMessage save(ReceiptPO po, String add) {
		return util.save(po, add);
	}

	public ArrayList<ReceiptPO> getAllRep(String add) {
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		ArrayList<Object> objects = new ArrayList<Object>();
 		for(Object object : objects){
 			receiptPOs.add((ReceiptPO)object);
 		}
 		return receiptPOs;
	}

	public ArrayList<ReceiptPO> getRepByDate(String date, String add) {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(add);
		ArrayList<ReceiptPO> dateReceiptPOs = getAllRep(add);
		for(ReceiptPO receiptPO : receiptPOs){
			if(receiptPO.getDate().equals(date))
				dateReceiptPOs.add(receiptPO);
		}
		return dateReceiptPOs;
	}

	public ReceiptPO getRepByNum(String num, String add) {
		File saveFile = new File(add);
		ReceiptPO po = null;
		try {
			FileInputStream fin = new FileInputStream(saveFile);
			ObjectInputStream is = new ObjectInputStream(fin);
			while (fin.available() > 0) {
				po = (ReceiptPO)is.readObject();
				if(po.getNum().equals(num))
					return po;
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return po;
	}

	public ResultMessage delete(int n, String add) {
		return util.delete(n, add);
	}

	public ResultMessage delete(String num, String add) {
		ArrayList<ReceiptPO> receiptPOs = getAllRep(add);
		util.clear(add);
		ReceiptPO po;
		for(int i = 0;i<receiptPOs.size();i++){
			po = receiptPOs.get(i);
			if(!po.getNum().equals(num))
				save(po, add);
		}
		return ResultMessage.SUCCESS;
	}
	
	public String createNum(String date, String add){
		ArrayList<ReceiptPO> receiptPOs = getRepByDate(date, add);
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
