package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import PO.ReceiptPO.ArriveRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.DeliverRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class GetRepCheckbl {
	private Receiptbl receiptbl = new Receiptbl();

	public ArriveRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.GetRep);
		return new ArriveRepVO((ArriveRepPO)receiptPO);
	}

	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.GetRep);
		ArrayList<ArriveRepVO> getRepVOs = ArriveRepVO.toArrayVO(receiptPOs);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < getRepVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			ArriveRepVO arriveRepVO = getRepVOs.get(i);
			arr.add(arriveRepVO.date);
			arr.add(arriveRepVO.num);
			arr.add(arriveRepVO.rep);
			arr.add(arriveRepVO.shipNum);
			arr.add(arriveRepVO.place);
			data.add(arr);
		}
		return data;
	}

}
