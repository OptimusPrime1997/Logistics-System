package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.GoodsVO;
import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.GetRepblService;
import util.enumData.Rep;

public class GetRepController extends ReceiptblController implements GetRepblService{
	private GetRepbl getRepbl = new GetRepbl();
	private GetRepCheckbl getRepCheckbl = new GetRepCheckbl();
	private GetRepShowbl getRepShowbl = new GetRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return getRepbl.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public ArriveRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return getRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		getRepbl.submit(vo);
	}

	@Override
	public ArrayList<ArriveRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArriveRepVO> getRepByDate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return getRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return getRepShowbl.initShow(num);
	}

	@Override
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) {
		// TODO Auto-generated method stub
		return getRepbl.initTable(rep, num, existOrders);
	}

	@Override
	public void transferOver(String num) {
		// TODO Auto-generated method stub
		getRepbl.transferOver(num);
	}


}
