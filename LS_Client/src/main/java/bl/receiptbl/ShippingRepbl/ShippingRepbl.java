package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import PO.Receipt.ShippingRepPO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShippingRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class ShippingRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ShippingRep, office);
	}

	public ShippingRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ShippingRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new ShippingRepVO((ShippingRepPO)receiptPO);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ShippingRepVO.toPO((ShippingRepVO) vo), Rep.ShippingRep);
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
		if(receiptPOs==null)
			return null;
		return ShippingRepVO.toArrayVO(receiptPOs);
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
