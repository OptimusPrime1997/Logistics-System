package bl.receiptbl.DeliverRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.DeliverVO;
import bl.managementbl.accountbl.Accountbl;

public class DeliverRepShowbl {
	
	private DeliverRepCheckbl deliverRepCheckbl = new DeliverRepCheckbl();
	private Accountbl accountbl = new Accountbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		DeliverRepVO deliverRepVO = deliverRepCheckbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < deliverRepVO.deliverVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			DeliverVO deliverVO = deliverRepVO.deliverVOs.get(i);
			arr.add(deliverVO.order);
			arr.add(deliverVO.receiverName);
			arr.add(deliverVO.receiverPhone);
			arr.add(deliverVO.address);
			data.add(arr);
		}
		return data;
	}
	
	public String getCourierName(String courierNum) 
			throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException,
			NumNotFoundException, IOException{
		return accountbl.findByAccountNum(courierNum).accountName;
	}

}
