package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import Exception.NumNotFoundException;
import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.ReceiptPO;
import VO.ManagementVO.BankAccountVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import VO.ReceiptVO.ReceiptVO;
import bl.managementbl.bankaccountbl.BankAccountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import util.enumData.PayThing;
import util.enumData.Rep;

public class PayRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	private BankAccountbl bankAccountbl = new BankAccountbl();
	
	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.PayRep);
	}

	public void submit(ReceiptVO vo) throws IOException, NotBoundException {
		// TODO Auto-generated method stub
		receiptbl.clearSave(Rep.PayRep);
		receiptbl.submit(PayRepVO.toPO((PayRepVO) vo), Rep.PayRep);
	}
	
	public PayRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.PayRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new PayRepVO((PayRepPO) receiptPO);
	}
	
	public ArrayList<PayRepVO> getAllRep() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.PayRep);
		return PayRepVO.toArrayVO(receiptPOs);
	}
	
	public Vector<Object> initTable(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		PayRepVO payRepVO = getRepByNum(num);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < payRepVO.payVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			PayVO payVO = payRepVO.payVOs.get(i);
			arr.add(payVO.payThing);
			arr.add(payVO.money);
			arr.add(payVO.bankAccountNum);
			arr.add(payVO.remark);
			data.add(arr);
		}
		return data;
	}

	public ArrayList<PayRepVO> getRepByDate(String date) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.PayRep);
		if(receiptPOs==null)
			return null;
		return PayRepVO.toArrayVO(receiptPOs);
	}

	public PayThing getPayThing(String type) {
		// TODO Auto-generated method stub
		type = type.split("(")[0];
		return PayThing.getPayThing(type);
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
	
	public void minusMoneyInBankAccount (String bankAccount, double money) 
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException{
		BankAccountVO bankAccountVO = bankAccountbl.findByBankAccountNum(bankAccount);
		bankAccountVO.balance -= money;
		bankAccountbl.update(bankAccountVO);
	}
	
}
