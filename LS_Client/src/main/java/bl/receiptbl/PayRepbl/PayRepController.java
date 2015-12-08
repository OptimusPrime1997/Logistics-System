package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PayRepblService;
import util.enumData.ResultMessage;

public class PayRepController extends ReceiptblController implements PayRepblService{
	private PayRepbl payRepbl = new PayRepbl();
	private PayRepCheckbl payRepCheckbl = new PayRepCheckbl();
	private PayRepShowbl payRepShowbl = new PayRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return payRepbl.createNum(date);
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
	public PayRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return payRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		payRepbl.submit(vo);
	}

	@Override
	public ArrayList<PayRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayRepVO> getRepByDate(String date)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return payRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return payRepShowbl.initShow(num);
	}

}
