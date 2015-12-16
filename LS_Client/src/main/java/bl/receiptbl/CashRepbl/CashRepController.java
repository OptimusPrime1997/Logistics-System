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
import blservice.receiptblservice.PostReceiptblService;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;

public class CashRepController extends ReceiptblController 
implements CashRepblService, PostReceiptblService{
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
	public Vector<Object> initTable(String office) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException{
		// TODO Auto-generated method stub
		return cashRepbl.initTable(office);
	}
	
	@Override
	public void submit(ReceiptVO vo, String office) 
			throws NotBoundException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		cashRepbl.submit(vo, office);
	}

	@Override
	public ArrayList<CashRepVO> getAllRep(String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<CashRepVO> getRepByDate(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.getRepByDate(date, office);
	}

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CashRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return cashRepbl.getRepByNum(num);
	}

	@Override
	public void addMoneyInBankAccount(String bankAccount, double money) throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		cashRepbl.addMoneyInBankAccount(bankAccount, money);
	}

	@Override
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.showBankAccount();
	}

	@Override
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
