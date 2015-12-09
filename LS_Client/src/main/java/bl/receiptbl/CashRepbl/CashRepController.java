package bl.receiptbl.CashRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.GoodsVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.CashRepblService;
import Exception.AddMoneyInBankException;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;

public class CashRepController extends ReceiptblController implements CashRepblService{
	private CashRepbl cashRepbl = new CashRepbl();
	private CashRepCheckbl cashRepCheckbl = new CashRepCheckbl();

	@Override
	public ArrayList<GoodsVO> getGoods(String courierNum, String date) {
		// TODO Auto-generated method stub
		return cashRepbl.getGoods(courierNum,date);
	}

	@Override
	public String getCourierName(String courierNum) throws RemoteException, FileNotFoundException, 
	ClassNotFoundException, NameNotFoundException, NumNotFoundException, IOException{
		// TODO Auto-generated method stub
		return cashRepbl.getCourierName(courierNum);
	}

	@Override
	public double getMoneySum(ArrayList<GoodsVO> arrGoods) {
		// TODO Auto-generated method stub
		return cashRepbl.getMoneySum(arrGoods);
	}

	@Override
	public Vector<Object> initTable(String num) throws NotBoundException, ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		return cashRepbl.initTable(num);
	}
	
	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException{
		// TODO Auto-generated method stub
		cashRepbl.submit(vo);
	}

	@Override
	public ArrayList<CashRepVO> getAllRep() throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.getAllRep();
	}

	@Override
	public ArrayList<CashRepVO> getRepByDate(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.getRepByDate(date);
	}

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.createNum(date);
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
	public CashRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.getRepByNum(num);
	}

	@Override
	public void addMoneyInBankAccount(String bankAccount, double money) throws AddMoneyInBankException, FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		cashRepbl.addMoneyInBankAccount(bankAccount, money);
	}

	@Override
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.showBankAccount();
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
