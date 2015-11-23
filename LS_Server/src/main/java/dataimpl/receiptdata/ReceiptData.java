package dataimpl.receiptdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import PO.ReceiptPO;
import util.enumData.*;

public class ReceiptData {

	public ResultMessage submit(ReceiptPO po, String add) {
		// TODO Auto-generated method stub
		File submitFile = new File(add);
		ObjectOutputStream os;
		 try {
			os = new ObjectOutputStream(new FileOutputStream(submitFile));
			os.writeObject(po);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(ReceiptPO po, String add) {
		// TODO Auto-generated method stub
		File saveFile = new File(add);
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(saveFile));
			os.writeObject(po);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ReceiptPO> getAllRep(String add) {
		// TODO Auto-generated method stub
		File saveFile = new File(add);
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(saveFile));
			ReceiptPO po = (ReceiptPO)is.readObject();
			receiptPOs.add(po);
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return receiptPOs;
	}

	public ArrayList<ReceiptPO> getRepByDate(String date, String add) {
		// TODO Auto-generated method stub
		File saveFile = new File(add);
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(saveFile));
			ReceiptPO po = (ReceiptPO)is.readObject();
			if(po.getDate()==date)
				receiptPOs.add(po);
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return receiptPOs;
	}

	public ReceiptPO getRepByNum(String num, String add) {
		// TODO Auto-generated method stub
		File saveFile = new File(add);
		ReceiptPO receiptPO = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(saveFile));
			ReceiptPO po = (ReceiptPO)is.readObject();
			if(po.getNum()==num)
				receiptPO = po;
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return receiptPO;
	}

	public ResultMessage delete(int n, String add) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage delete(String num, String add) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String createNum(String add){
		return null;
	}

}
