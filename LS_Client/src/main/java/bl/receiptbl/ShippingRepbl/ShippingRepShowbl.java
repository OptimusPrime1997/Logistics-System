package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ShippingRepVO;

public class ShippingRepShowbl {
	
	private ShippingRepbl shippingRepbl = new ShippingRepbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ShippingRepVO shippingRepVO = shippingRepbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> orders = shippingRepVO.goods;
		for(int i = 0;i < orders.size();i++){
			data.add(orders.get(i));
		}
		return data;
	}

}
