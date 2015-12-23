package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import PO.Receipt.ShipmentRepPO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ShipmentRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class ShipmentRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ShipmentRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ShipmentRepVO.toPO((ShipmentRepVO) vo), Rep.ShipmentRep);
	}

	public ArrayList<ShipmentRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ShipmentRep, office);
		return ShipmentRepVO.toArrayVO(receiptPOs);
	}

	public ShipmentRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ShipmentRep);
		return new ShipmentRepVO((ShipmentRepPO)receiptPO);
	}

	public String getTruckSum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		String truckNum = createNum(date, office);
		for(int i = 0;i <= truckNum.length();i++){
			if(truckNum.charAt(i)=='0'){
				truckNum = truckNum.substring(1);
			}
			else {
				break;
			}
		}
		return truckNum;
	}
	
	public boolean isTrueAccount(String num){
		return receiptbl.isTrueAccount(num);
	}
	
	public boolean isTrueOrder(String order){
		return receiptbl.isTrueOrder(order);
	}
	
}
