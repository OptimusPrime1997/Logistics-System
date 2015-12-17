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
import VO.ManagementVO.BankAccountVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import VO.ReceiptVO.ReceiptVO;
import bl.managementbl.bankaccountbl.BankAccountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import dataservice.receiptdataservice.PayRepDataService;
import util.enumData.PayThing;
import util.enumData.Rep;

public class PayRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	private BankAccountbl bankAccountbl = new BankAccountbl();
	private ReceiptClient client = new ReceiptClient();
	private static PayRepDataService payRepDataService = null;
	
	public PayRepDataService getPayRepDataService(
			) throws MalformedURLException, RemoteException, NotBoundException{
		if (payRepDataService==null) 
			payRepDataService = client.getPayRepDataService();
		return payRepDataService;
	}
	
	public void submit(ReceiptVO vo)
			throws IOException, NotBoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		getPayRepDataService().clearPaySubmit();
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
		ArrayList<PayRepPO> payRepPOs = getPayRepDataService().getAllPayRep();
		return PayRepVO.toArrayVO(payRepPOs);
	}
	
	public PayRepVO getSubmitPayRep() 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException{
		PayRepPO payRepPO = getPayRepDataService().getSubmitPayRep();
		return new PayRepVO(payRepPO);
	}
	
	public Vector<Object> initTable()
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		PayRepVO payRepVO = getSubmitPayRep();
		Vector<Object> data = new Vector<Object>();
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
	
}
