package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.PayRepVO;
import VO.Receipt.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PayRepblService;
import util.enumData.ResultMessage;

public class PayRepController extends ReceiptblController implements PayRepblService{
	private PayRepbl payRepbl = new PayRepbl();
	private PayRepCheckbl payRepCheckbl = new PayRepCheckbl();

	@Override
	public PayRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return payRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) 
			throws NotBoundException, IOException{
		// TODO Auto-generated method stub
		payRepbl.submit(vo);
	}

	@Override
	public Vector<Object> initTable() 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return payRepbl.initTable();
	}

	@Override
	public PayRepVO getSubmitPayRep() 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException{
		return payRepbl.getSubmitPayRep();
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return payRepCheckbl.initCheck();
	}

	@Override
	public String payPeople() throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return payRepbl.payPeople();
	}

	@Override
	public Vector<Object> initShow(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return payRepbl.initShow(num);
	}

}
