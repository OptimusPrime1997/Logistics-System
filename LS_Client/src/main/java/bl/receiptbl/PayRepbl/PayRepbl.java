package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.Receipt.PayRepPO;
import PO.Receipt.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.BankAccountVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.PayVO;
import VO.Receipt.ReceiptVO;
import bl.loginbl.LoginblController;
import bl.managementbl.accountbl.Accountbl;
import bl.managementbl.bankaccountbl.BankAccountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import dataservice.receiptdataservice.PayRepDataService;
import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.Rep;

public class PayRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	private BankAccountbl bankAccountbl = new BankAccountbl();
	private Accountbl accountbl = new Accountbl();
	private ReceiptClient client = new ReceiptClient();
	private LoginblController login = new LoginblController();
	private static PayRepDataService payRepDataService = null;
	
	public PayRepDataService getPayRepDataService()
			 throws MalformedURLException, RemoteException, NotBoundException{
		if (payRepDataService==null) 
			payRepDataService = client.getPayRepDataService();
		return payRepDataService;
	}
	
	public void submit(ReceiptVO vo)
			throws IOException, NotBoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		getPayRepDataService().clearPaySubmit();
		receiptbl.submit(PayRepVO.toPO((PayRepVO) vo), Rep.PayRep);
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.MONEY_IN_AND_OUT_MANAGEMENT, operatorID, CurrentTime.getTime());
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
		ArrayList<PayRepPO> payRepPOs = getPayRepDataService().getAllPayRep();
		if(payRepPOs==null)
			return null;
		return PayRepVO.toArrayVO(payRepPOs);
	}
	
	public PayRepVO getSubmitPayRep() 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException{
		PayRepPO payRepPO = getPayRepDataService().getSubmitPayRep();
		if(payRepPO==null)
			return null;
		return new PayRepVO(payRepPO);
	}
	
	public Vector<Object> initTable()
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		PayRepVO payRepVO = getSubmitPayRep();
		Vector<Object> data = new Vector<Object>();
		if(payRepVO==null)
			return null;
		for(int i = 0;i < payRepVO.payVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			PayVO payVO = payRepVO.payVOs.get(i);
			arr.add(payVO.payThing.getChineseName());
			arr.add(payVO.money+"");
			arr.add(payVO.bankAccountNum);
			arr.add(payVO.remark);
			data.add(arr);
		}
		return data;
	}

	public String getRefundTime(String type){
		type = type.split("(")[1];
		type = type.split(")")[0];
		return type;
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
	
	public String payPeople() 
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException{
		String num = login.getCurrentOptorId();
		AccountVO accountVO = accountbl.findByAccountNum(num);
		return accountVO.accountName;
	}
	
}
