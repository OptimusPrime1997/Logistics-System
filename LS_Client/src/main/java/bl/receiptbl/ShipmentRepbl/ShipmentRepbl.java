package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.ShipmentRepPO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class ShipmentRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ShipmentRep);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ShipmentRepVO.toPO((ShipmentRepVO) vo), Rep.ShipmentRep);
	}

	public ArrayList<ShipmentRepVO> getAllRep() 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ShipmentRep);
		return ShipmentRepVO.toArrayVO(receiptPOs);
	}

	public ShipmentRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ShipmentRep);
		return new ShipmentRepVO((ShipmentRepPO)receiptPO);
	}

	public String getTruckSum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return createNum(date);
	}

}
