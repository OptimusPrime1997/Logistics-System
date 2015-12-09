package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.ReceptionRepPO;
import VO.ReceiptVO.ReceptionRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class ReceptionRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();
	private ReceptionRepbl receptionRepbl = new ReceptionRepbl();

	public ReceptionRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ReceptionRep);
		return new ReceptionRepVO((ReceptionRepPO)receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceptionRepVO> receptionVOs = receptionRepbl.getAllRep();
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < receptionVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			ReceptionRepVO RecepitonRepVO = receptionVOs.get(i);
			arr.add(RecepitonRepVO.date);
			arr.add(RecepitonRepVO.num);
			arr.add(RecepitonRepVO.rep);
			arr.add(RecepitonRepVO.shipNum);
			arr.add(RecepitonRepVO.city);
			data.add(arr);
		}
		return data;
	}

}
