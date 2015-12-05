package bl.receiptbl.CashRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.GoodsVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.CashRepblService;
import util.enumData.ResultMessage;
import Exception.AddMoneyInBankException;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;

public class CashRepController extends ReceiptblController implements CashRepblService{
	private CashRepbl cashRepbl = new CashRepbl();

	@Override
	public ArrayList<GoodsVO> getGoods(String courierNum, String date) {
		// TODO Auto-generated method stub
		return cashRepbl.getGoods(courierNum,date);
	}

	@Override
	public String getCourierName(String courierNum) throws NameNotFoundException, FileNotFoundException, javax.naming.NameNotFoundException, ClassNotFoundException, NumNotFoundException, IOException{
		// TODO Auto-generated method stub
		return cashRepbl.getCourierName(courierNum);
	}

	@Override
	public double getMoneySum(ArrayList<GoodsVO> arrGoods) {
		// TODO Auto-generated method stub
		return cashRepbl.getMoneySum(arrGoods);
	}

	@Override
	public Vector<Object> initTable(String date) throws NotBoundException, ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		return cashRepbl.initTable(date);
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
	public ArrayList<CashRepVO> getRepBydate(String date) throws NotBoundException, ClassNotFoundException, IOException {
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
		cashRepbl.delete(n);
	}

	@Override
	public void delete(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		cashRepbl.delete(num);
	}

	@Override
	public CashRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return cashRepbl.getRepByNum(num);
	}

	@Override
	public void addMoneyInBankAccount() throws AddMoneyInBankException {
		// TODO Auto-generated method stub
		cashRepbl.addMoneyInBankAccount();
	}

}
