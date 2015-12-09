package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.GetRepVO;
import VO.ReceiptVO.ReceiptVO;
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
	public GetRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, 
	IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		getRepbl.submit(vo);
	}

	@Override
	public ArrayList<GetRepVO> getAllRep() throws NotBoundException, ClassNotFoundException, 
	IOException {
		// TODO Auto-generated method stub
		return getRepbl.getAllRep();
	}

	@Override
	public ArrayList<GetRepVO> getRepByDate(String date)
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
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepShowbl.initShow(num);
	}

	@Override
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepbl.initTable(rep, num, existOrders);
	}

	@Override
	public void transferOver(String num) {
		// TODO Auto-generated method stub
		getRepbl.transferOver(num);
	}

	@Override
	public String getDepart(Rep rep, String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return getRepbl.getDepart(rep, num);
	}


}
