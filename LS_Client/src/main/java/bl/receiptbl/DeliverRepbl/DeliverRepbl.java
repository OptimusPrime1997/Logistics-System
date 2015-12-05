package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ReceiptPO.DeliverRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class DeliverRepbl{
	Receiptbl receiptbl = new Receiptbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		return receiptbl.createNum(date, Rep.DeliverRep);
	}

	public void delete(String num) throws ClassNotFoundException, NotBoundException, IOException {
		receiptbl.delete(num, Rep.DeliverRep);
	}

	public DeliverRepVO getRepByNum(String num) throws ClassNotFoundException, NotBoundException, IOException {
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.DeliverRep);
		return new DeliverRepVO((DeliverRepPO)receiptPO);
	}

	public void delete(int n) throws ClassNotFoundException, IOException, NotBoundException {
		receiptbl.delete(n, Rep.DeliverRep);
	}

	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, IOException, NotBoundException {
		receiptbl.clearSubmit(Rep.DeliverRep);
		receiptbl.submit(DeliverRepVO.toPO((DeliverRepVO) vo), Rep.DeliverRep);
	}

	public ArrayList<DeliverRepVO> getAllRep() throws ClassNotFoundException, NotBoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.DeliverRep);
		return DeliverRepVO.toArrayVO(receiptPOs);
	}

		public ArrayList<DeliverRepVO> getRepByDate(String date) throws ClassNotFoundException, NotBoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.DeliverRep);
		if(receiptPOs==null)
			return null;
		return DeliverRepVO.toArrayVO(receiptPOs);
	}
		
		public ResultMessage checkOrderNum(String order){
			if(order.length()<10)
				return ResultMessage.REPNUM_LENGTH_LACKING;
			if(order.length()>10)
				return ResultMessage.REPNUM_LENGTH_OVER;
			return ResultMessage.ADD_SUCCESS;
		}
		
		public ResultMessage checkCourierNum(String courierNum){
			if(courierNum.length()<11)
				return ResultMessage.REPNUM_LENGTH_LACKING;
			if(courierNum.length()>11)
				return ResultMessage.REPNUM_LENGTH_OVER;
			return ResultMessage.ADD_SUCCESS;
		}
	
}
