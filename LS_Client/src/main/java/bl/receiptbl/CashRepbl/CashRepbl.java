package bl.receiptbl.CashRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import util.enumData.Rep;
import VO.GoodsVO;
import VO.ManagementVO.BankAccountVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.managementbl.accountbl.Accountbl;
import bl.managementbl.bankaccountbl.BankAccountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import Exception.*;
import PO.Receipt.CashRepPO;
import PO.Receipt.ReceiptPO;

public class CashRepbl {

	private Goodsbl goodsbl = new Goodsbl();
	private Accountbl accountbl = new Accountbl();
	private BankAccountbl bankAccountbl = new BankAccountbl();
	private Receiptbl receiptbl = new Receiptbl();

	public String getCourierName(String courierNum) throws RemoteException, FileNotFoundException, 
	ClassNotFoundException, NameNotFoundException, NumNotFoundException, IOException{
		return accountbl.findByAccountNum(courierNum).accountName;
	}

	public ArrayList<GoodsVO> getGoods(String courierNum, String date) {
		return goodsbl.getGoodsByGetCourier(courierNum, date);
	}

	public double getMoneySum(ArrayList<GoodsVO> arrGoods) {
		double moneysum = 0;
		for (int i = 0; i < arrGoods.size(); ++i) {
			moneysum += arrGoods.get(i).moneyTotal;
		}
		return moneysum;
	}

	public void submit(ReceiptVO vo, String office) 
			throws NotBoundException, IOException, ClassNotFoundException{
		receiptbl.clearSubmit(Rep.CashRep, office);
		receiptbl.submit(CashRepVO.toPO((CashRepVO) vo), Rep.CashRep);
	}

	public CashRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.CashRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new CashRepVO((CashRepPO)receiptPO);
	}
	
	public void addMoneyInBankAccount(String bankAccount, double money) 
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		BankAccountVO bankAccountVO = bankAccountbl.findByBankAccountNum(bankAccount);
		bankAccountVO.balance += money;
		bankAccountbl.update(bankAccountVO);
	}

	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException {
		ArrayList<BankAccountVO> bankAccountVOs = bankAccountbl.show();
		Vector<String> bankAccounts = new Vector<String>();
		for(int i = 0;i<bankAccountVOs.size();i++){
			BankAccountVO bankAccountVO = bankAccountVOs.get(i);
			bankAccounts.add(bankAccountVO.bankAccountNum);
		}
		return bankAccounts;
	}

	public ArrayList<CashRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException{
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.CashRep, office);
		return CashRepVO.toArrayVO(receiptPOs);
	}
	
	public CashRepVO getSubmitCashRep(String office) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException{
		ReceiptPO receiptPO = receiptbl.getSubmitRep(Rep.CashRep, office);
		if(receiptPO==null)
			return null;
		return new CashRepVO((CashRepPO) receiptPO);
	}
	
	public Vector<Object> initTable(String office) throws ClassNotFoundException, 
	NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		CashRepVO cashRepVO = getSubmitCashRep(office);
		if(cashRepVO==null)
			return data;
		for(int i = 0;i < cashRepVO.cashVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			CashVO cashVO = cashRepVO.cashVOs.get(i);
			arr.add(cashVO.courierName);
			arr.add(cashVO.courierNum);
			arr.add(cashVO.money+"");
			arr.add(cashVO.remark);
			data.add(arr);
		}
		return data;
	}

	public ArrayList<CashRepVO> getRepByDate(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.CashRep, office);
		if(receiptPOs==null)
			return null;
		return CashRepVO.toArrayVO(receiptPOs);
	}
	
}
