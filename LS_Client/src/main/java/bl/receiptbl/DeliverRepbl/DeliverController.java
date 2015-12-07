package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
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
	}

	@Override
	public void delete(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public DeliverRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 return null;
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		 deliverRep.submit(vo);
	}

	@Override
	public ArrayList<DeliverRepVO> getAllRep() throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliverRepVO> getRepBydate(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRep.getRepByDate(date);
	}

	@Override
	public ResultMessage checkCourierNum(String string) {
		// TODO Auto-generated method stub
		return deliverRep.checkCourierNum(string);
	}

	@Override
	public String getNameByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return deliverRep.getNameByOrder(order);
	}

	@Override
	public String getPhoneByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return deliverRep.getPhoneByOrder(order);
	}

	@Override
	public String getAddressByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return deliverRep.getAddressByOrder(order);
	}

	@Override
	public Vector<Object> checkAll() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
