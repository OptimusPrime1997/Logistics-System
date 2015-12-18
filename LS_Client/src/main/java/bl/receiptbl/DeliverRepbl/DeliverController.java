package bl.receiptbl.DeliverRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.DeliverRepVO;
import VO.Receipt.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.DeliverRepblService;
import blservice.receiptblservice.FindAccountblService;
import blservice.receiptblservice.PostReceiptblService;
import blservice.receiptblservice.SubmitblService;
import util.enumData.ResultMessage;

public class DeliverController extends ReceiptblController 
implements DeliverRepblService, PostReceiptblService, SubmitblService, FindAccountblService{
	private DeliverRepbl deliverRepbl = new DeliverRepbl();
	private DeliverRepCheckbl deliverRepCheckbl = new DeliverRepCheckbl();
	private DeliverRepShowbl deliverRepShowbl =  new DeliverRepShowbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRepbl.createNum(date, office);
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
	public ArrayList<DeliverRepVO> getAllRep(String office) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<DeliverRepVO> getRepByDate(String date, String office) 
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
	public Vector<Object> initCheck(String office) 
			throws ClassNotFoundException, NotBoundException, IOException, 
			NameNotFoundException, NumNotFoundException {
		// TODO Auto-generated method stub
		return deliverRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return deliverRepShowbl.initShow(num);
	}

	@Override
	public boolean isTrueAccount(String num) {
		// TODO Auto-generated method stub
		return deliverRepbl.isTrueAccount(num);
	}

	@Override
	public String getCourierName(String courierNum) throws RemoteException, FileNotFoundException,
			ClassNotFoundException, NameNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return deliverRepShowbl.getCourierName(courierNum);
	}

}
