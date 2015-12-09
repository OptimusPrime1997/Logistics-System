package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import PO.ReceiptPO.DeliverRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.DeliverRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class DeliverRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();
	private CashRepbl cashRepbl = new CashRepbl();
	private DeliverRepbl deliverRepbl = new DeliverRepbl();

	public DeliverRepVO getRepByNum(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.DeliverRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new DeliverRepVO((DeliverRepPO)receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException, NameNotFoundException, NumNotFoundException {
		ArrayList<DeliverRepVO> deliverRepVOs = deliverRepbl.getAllRep();
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < deliverRepVOs.size();i++){
			DeliverRepVO deliverRepVO = deliverRepVOs.get(i);
			Vector<Object> arr = new Vector<Object>();
			arr.add(deliverRepVO.date);
			arr.add(deliverRepVO.num);
			arr.add(deliverRepVO.deliverCourierNum);
			arr.add(cashRepbl.getCourierName(deliverRepVO.deliverCourierNum));
			data.add(arr);
		}
		return data;
	}

}
