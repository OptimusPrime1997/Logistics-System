package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.DeliverRepblService;
import util.enumData.ResultMessage;

public class DeliverController extends ReceiptblController implements DeliverRepblService{
	private DeliverRepbl deliverRepbl = new DeliverRepbl();
	private DeliverRepCheckbl deliverRepCheckbl = new DeliverRepCheckbl();
	private DeliverRepShowbl deliverRepShowbl =  new DeliverRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRepbl.createNum(date);
	}

	@Override
	public void delete(int n) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stubxw
	}

	@Override
	public void delete(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public DeliverRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		 return deliverRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		 deliverRepbl.submit(vo);
	}

	@Override
	public ArrayList<DeliverRepVO> getAllRep() 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRepbl.getAllRep();
	}

	@Override
	public ArrayList<DeliverRepVO> getRepByDate(String date) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkCourierNum(String string) {
		// TODO Auto-generated method stub
		return deliverRepbl.checkCourierNum(string);
	}

	@Override
	public String getNameByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return deliverRepbl.getNameByOrder(order);
	}

	@Override
	public String getPhoneByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return deliverRepbl.getPhoneByOrder(order);
	}

	@Override
	public String getAddressByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return deliverRepbl.getAddressByOrder(order);
	}

	@Override
	public Vector<Object> initCheck() 
			throws ClassNotFoundException, NotBoundException, IOException, 
			NameNotFoundException, NumNotFoundException {
		// TODO Auto-generated method stub
		return deliverRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return deliverRepShowbl.initShow(num);
	}

}
