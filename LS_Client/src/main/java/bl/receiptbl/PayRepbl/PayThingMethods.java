package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ManagementVO.BankAccountVO;
import bl.managementbl.bankaccountbl.BankAccountbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PayThingblService;
import util.enumData.ResultMessage;

public class PayThingMethods extends ReceiptblController implements PayThingblService{
	
	private PayRepbl payRepbl = new PayRepbl();
	private BankAccountbl bankAccountbl = new BankAccountbl();

	@Override
	public ResultMessage checkMoney(double money) {
		// TODO Auto-generated method stub
		return payRepbl.checkMoney(money);
	}
	
	@Override
	public void minusMoneyInBankAccount(String bankAccount, double money) 
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		payRepbl.minusMoneyInBankAccount(bankAccount, money);
	}
	
	@Override
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return payRepbl.showBankAccount();
	}
	
	public double showBankBalance(String bankAccount) 
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		BankAccountVO bankAccountVO = bankAccountbl.findByBankAccountNum(bankAccount);
		return bankAccountVO.balance;
	}
}
