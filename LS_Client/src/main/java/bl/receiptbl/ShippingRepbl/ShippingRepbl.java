package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.ShippingRepPO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShippingRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class ShippingRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ShippingRep);
	}

	public ShippingRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ShippingRep);
		return new ShippingRepVO((ShippingRepPO)receiptPO);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ShippingRepVO.toPO((ShippingRepVO) vo), Rep.ShippingRep);
	}

	public ArrayList<ShippingRepVO> getAllRep() 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ShippingRep);
		return ShippingRepVO.toArrayVO(receiptPOs);
	}

}
