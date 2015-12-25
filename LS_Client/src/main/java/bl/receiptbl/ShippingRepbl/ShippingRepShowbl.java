package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.ShippingRepVO;

public class ShippingRepShowbl {
	
	private ShippingRepbl shippingRepbl = new ShippingRepbl();

	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ShippingRepVO shippingRepVO = shippingRepbl.getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> orders = shippingRepVO.goods;
		for(int i = 0;i < orders.size();i++){
			Vector<String> arr = new Vector<String>();
			arr.add(orders.get(i));
			data.add(arr);
		}
		return data;
	}

}
