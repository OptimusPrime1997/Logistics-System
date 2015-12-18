package bl.receiptbl.TransferRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;
import util.enumData.City;
import util.enumData.ShipForm;

public class TransferRepCheckbl {
	
	private TransferRepbl transferRepbl = new TransferRepbl();

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TransferRepVO> transferRepVOs = transferRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < transferRepVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			TransferRepVO transferRepVO = transferRepVOs.get(i);
			arr.add(transferRepVO.date);
			arr.add(transferRepVO.num);
			arr.add(ShipForm.toFrendlyString(transferRepVO.form));
			arr.add(transferRepVO.carNum);
			arr.add(City.toString(transferRepVO.city));
			data.add(arr);
		}
		return data;
	}

}
