package bl.receiptbl.TransferRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ShippingRepVO;
import VO.ReceiptVO.TransferRepVO;

public class TransferRepCheckbl {
	
	private TransferRepbl transferRepbl = new TransferRepbl();

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TransferRepVO> transferRepVOs = transferRepbl.getAllRep();
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < transferRepVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			TransferRepVO transferRepVO = transferRepVOs.get(i);
			arr.add(transferRepVO.date);
			arr.add(transferRepVO.num);
			arr.add(transferRepVO.form);
			arr.add(transferRepVO.carNum);
			arr.add(transferRepVO.city);
			data.add(arr);
		}
		return data;
	}

}
