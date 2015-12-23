package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import PO.Receipt.ShippingRepPO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ShippingRepVO;
import bl.loginbl.LoginblController;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.Rep;

public class ShippingRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private LoginblController login = new LoginblController();
	
	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ShippingRep, office);
	}

	public ShippingRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ShippingRep);
		return new ShippingRepVO((ShippingRepPO)receiptPO);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ShippingRepVO.toPO((ShippingRepVO) vo), Rep.ShippingRep);
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.TRANSFER_CTR_SHIP_MANAGEMENT, operatorID, CurrentTime.getTime());
	}

	public ArrayList<ShippingRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ShippingRep, office);
		return ShippingRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<ShippingRepVO> getRepByDate(String date, String office)
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.ShippingRep, office);
		return ShippingRepVO.toArrayVO(receiptPOs);
	}
	
	public boolean isTrueAccount(String num){
		return receiptbl.isTrueAccount(num);
	}
	
	public boolean isTrueOrder(String order){
		return receiptbl.isTrueOrder(order);
	}
	
}
