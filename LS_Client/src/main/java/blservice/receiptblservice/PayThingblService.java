package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import util.enumData.ResultMessage;

/**
 * @author bismuth
 *
 */
public interface PayThingblService {

	/**
	 * 显示银行账户
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException;

	/**
	 * 从银行账户中减去付款金额
	 * 
	 * @param bankAccount
	 * @param money
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NumNotFoundException
	 * @throws IOException
	 */
	public void minusMoneyInBankAccount(String bankAccount, double money)
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;

	/**
	 * 检查输入金额是否大于0
	 * 
	 * @param money
	 * @return
	 */
	public ResultMessage checkMoney(double money);

	/**
	 * 显示银行账户余额
	 * 
	 * @param bankAccount
	 * @return
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NameNotFoundException
	 * @throws IOException
	 * @throws NumNotFoundException 
	 */
	public double showBankBalance(String bankAccount) throws FileNotFoundException, ClassNotFoundException, NameNotFoundException, IOException, NumNotFoundException;
}
