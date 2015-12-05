package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.DeliverRepblService;
import util.enumData.ResultMessage;

public class DeliverController extends ReceiptblController implements DeliverRepblService{
	DeliverRepbl deliverRep = new DeliverRepbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRep.createNum(date);
	}

	@Override
	public void delete(int n) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		deliverRep.delete(n);
	}

	@Override
	public void delete(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 deliverRep.delete(num);
	}

	@Override
	public DeliverRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 return deliverRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		 deliverRep.submit(vo);
	}

	@Override
	public ArrayList<DeliverRepVO> getAllRep() throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRep.getAllRep();
	}

	@Override
	public ArrayList<DeliverRepVO> getRepBydate(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRep.getRepByDate(date);
	}

	@Override
	public ResultMessage checkOrderNum(String order) {
		// TODO Auto-generated method stub
		return deliverRep.checkOrderNum(order);
	}

	@Override
	public ResultMessage checkCourierNum(String courierNum) {
		// TODO Auto-generated method stub
		return deliverRep.checkOrderNum(courierNum);
	}

}
