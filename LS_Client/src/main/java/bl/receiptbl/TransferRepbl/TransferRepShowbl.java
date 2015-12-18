package bl.receiptbl.TransferRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.TransferRepVO;

public class TransferRepShowbl {
	
	private TransferRepbl transferRepbl = new TransferRepbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		TransferRepVO transferRepVO = transferRepbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> orders = transferRepVO.goods;
		for(int i = 0; i < orders.size();i++){
			data.add(orders.get(i));
		}
		return data;
	}

}
