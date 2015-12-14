package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ShippingRepVO;

public class ShippingRepCheckbl {
	
	private ShippingRepbl shippingRepbl = new ShippingRepbl();

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ShippingRepVO> shippingRepVOs = shippingRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < shippingRepVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			ShippingRepVO shippingRepVO = shippingRepVOs.get(i);
			arr.add(shippingRepVO.date);
			arr.add(shippingRepVO.num);
			arr.add(shippingRepVO.plateNum);
			arr.add(shippingRepVO.driverNum);
			arr.add(shippingRepVO.destination);
			data.add(arr);
		}
		return data;
	}

}
