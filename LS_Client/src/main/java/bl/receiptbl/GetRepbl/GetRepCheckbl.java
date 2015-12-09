package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.ReceiptPO.GetRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.GetRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class GetRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();
	private GetRepbl getRepbl = new GetRepbl();

	public GetRepVO getRepByNum(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.GetRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new GetRepVO((GetRepPO)receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GetRepVO> getRepVOs = getRepbl.getAllRep();
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < getRepVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			GetRepVO GetRepVO = getRepVOs.get(i);
			arr.add(GetRepVO.date);
			arr.add(GetRepVO.num);
			arr.add(GetRepVO.rep);
			arr.add(GetRepVO.shipNum);
			arr.add(GetRepVO.depart);
			data.add(arr);
		}
		return data;
	}

}
