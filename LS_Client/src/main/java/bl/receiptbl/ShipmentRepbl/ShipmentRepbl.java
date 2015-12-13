package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.ShipmentRepPO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;
import util.enumData.ResultMessage;

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
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new ShipmentRepVO((ShipmentRepPO)receiptPO);
	}

	public String getTruckSum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return createNum(date, office);
	}
	
	public ResultMessage checkDriverNum(String string){
		if(string.length() < 11)
			return ResultMessage.DRIVER_NUM_LACKING;
		if(string.length() > 11)
			return ResultMessage.DRIVER_NUM_OVER;
		for (int i = 0; i < 11; i++) {
			if (string.charAt(i) < '0' || string.charAt(i) > '9')
				return ResultMessage.REPNUM_NOT_ALL_NUM;
		}
		return ResultMessage.SUCCESS;
	}
	
	public boolean isTrueAccount(String num){
		return receiptbl.isTrueAccount(num);
	}

}
