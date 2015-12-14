package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ShipmentRepVO;

public class ShipmentRepCheckbl {
	
	private ShipmentRepbl shipmentRepbl = new ShipmentRepbl();

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ShipmentRepVO> shipmentRepVOs = shipmentRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < shipmentRepVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			ShipmentRepVO shipmentRepVO = shipmentRepVOs.get(i);
			arr.add(shipmentRepVO.date);
			arr.add(shipmentRepVO.num);
			arr.add(shipmentRepVO.plateNum);
			arr.add(shipmentRepVO.driverNum);
			data.add(arr);
		}
		return data;
	}

}
