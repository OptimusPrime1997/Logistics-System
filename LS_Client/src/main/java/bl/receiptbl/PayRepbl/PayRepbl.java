package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import util.enumData.Rep;

public class PayRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.PayRep);
	}

	public void submit(ReceiptVO vo) throws IOException, NotBoundException {
		// TODO Auto-generated method stub
		receiptbl.clearSave(Rep.PayRep);
		receiptbl.submit(PayRepVO.toPO((PayRepVO) vo), Rep.PayRep);
	}
	
	public PayRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.PayRep);
		return new PayRepVO((PayRepPO) receiptPO);
	}
	
	public ArrayList<PayRepVO> getAllRep() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.PayRep);
		return PayRepVO.toArrayVO(receiptPOs);
	}
	
	public Vector<Object> initTable(String num) throws ClassNotFoundException, NotBoundException, 
	IOException {
		// TODO Auto-generated method stub
		PayRepVO payRepVO = getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < payRepVO.payVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			PayVO payVO = payRepVO.payVOs.get(i);
			arr.add(payVO.payThing);
			arr.add(payVO.money);
			arr.add(payVO.bankAccountNum);
			arr.add(payVO.remark);
			data.add(arr);
		}
		return data;
	}

	public ArrayList<PayRepVO> getRepByDate(String date) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.PayRep);
		if(receiptPOs==null)
			return null;
		return PayRepVO.toArrayVO(receiptPOs);
	}
	
}
