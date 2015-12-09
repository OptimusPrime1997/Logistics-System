package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.ReceptionRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ReceptionRepblService;
import util.enumData.Rep;

public class ReceptionRepController extends ReceiptblController implements ReceptionRepblService{
	private ReceptionRepbl receptionRepbl = new ReceptionRepbl();
	private ReceptionRepCheckbl receptionRepCheckbl = new ReceptionRepCheckbl();
	private ReceptionRepShowbl receptionRepShowbl = new ReceptionRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepbl.createNum(date);
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
	public ReceptionRepVO getRepByNum(String num)
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receptionRepbl.submit(vo);
	}

	@Override
	public ArrayList<ReceptionRepVO> getAllRep()
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepbl.getAllRep();
	}

	@Override
	public ArrayList<ReceptionRepVO> getRepByDate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepShowbl.initShow(num);
	}

	@Override
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepbl.initTable(rep, num, existOrders);
	}

	@Override
	public void transferOver(String num) {
		// TODO Auto-generated method stub
		receptionRepbl.transferOver(num);
	}


}
