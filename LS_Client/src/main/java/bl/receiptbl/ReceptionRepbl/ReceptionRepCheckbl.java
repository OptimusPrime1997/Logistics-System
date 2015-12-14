package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.ReceptionRepPO;
import VO.ReceiptVO.ReceptionRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.City;
import util.enumData.Rep;

public class ReceptionRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();
	private ReceptionRepbl receptionRepbl = new ReceptionRepbl();

	public ReceptionRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.ReceptionRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new ReceptionRepVO((ReceptionRepPO)receiptPO);
	}

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceptionRepVO> receptionVOs = receptionRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < receptionVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			ReceptionRepVO RecepitonRepVO = receptionVOs.get(i);
			arr.add(RecepitonRepVO.date);
			arr.add(RecepitonRepVO.num);
			arr.add(RecepitonRepVO.rep.getChineseName());
			arr.add(RecepitonRepVO.shipNum);
			arr.add(City.toString(RecepitonRepVO.city));
			data.add(arr);
		}
		return data;
	}

}
