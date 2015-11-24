package dataimpl.receiptdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import PO.ReceiptPO;
import util.enumData.*;

public class ReceiptData {

	public ResultMessage submit(ReceiptPO po, String add) {
		// TODO Auto-generated method stub
		File submitFile = new File(add);
		try {
			FileOutputStream fo = new FileOutputStream(submitFile, true);
			ObjectOutputStream os;
			if(submitFile.length()<1)
				os = new ObjectOutputStream(fo);
			else
				os = new MyObjectOutputStream(fo);
			os.writeObject(po);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage save(ReceiptPO po, String add) {
		// TODO Auto-generated method stub
		File saveFile = new File(add);
		try {
			FileOutputStream fo = new FileOutputStream(saveFile, true);
			ObjectOutputStream os;
			if(saveFile.length()<1)
				os = new ObjectOutputStream(fo);
			else
				os = new MyObjectOutputStream(fo);
			os.writeObject(po);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}

	public ArrayList<ReceiptPO> getAllRep(String add) {
		// TODO Auto-generated method stub
		File saveFile = new File(add);
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		try {
			FileInputStream fin = new FileInputStream(saveFile);
			ObjectInputStream is = new ObjectInputStream(fin);
			while (fin.available() > 0) {
				ReceiptPO po = (ReceiptPO)is.readObject();
				receiptPOs.add(po);
			}
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
			FileInputStream fin = new FileInputStream(saveFile);
			ObjectInputStream is = new ObjectInputStream(fin);
			while (fin.available() > 0) {
				ReceiptPO po = (ReceiptPO)is.readObject();
				if(po.getDate().equals(date))
					receiptPOs.add(po);
			}
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
		try {
			FileInputStream fin = new FileInputStream(saveFile);
			ObjectInputStream is = new ObjectInputStream(fin);
			while (fin.available() > 0) {
				ReceiptPO po = (ReceiptPO)is.readObject();
				if(po.getNum().equals(num))
					return po;
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return null;
	}

	public void clear(String add){
		File file = new File(add);
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultMessage delete(int n, String add) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = getAllRep(add);
		clear(add);
		for(int i = n;i<receiptPOs.size();i++)
			save(receiptPOs.get(i), add);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(String num, String add) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = getAllRep(add);
		clear(add);
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
