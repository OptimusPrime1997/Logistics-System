package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.GoodsVO;
import VO.Receipt.ReceiptVO;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;

/**
 * @author bismuth
 *
 */
public interface CashRepblService extends ReceiptblService{
	
	
	/**
	 * 通过快递员编号得到快递员一天收到所有货物
	 * @param courierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoods(String courierNum, String date);

	/**
	 * 通过快递员编号得到名字
	 * @param courierNum
	 * @return
	 * @throws RemoteException 
	 * @throws javax.naming.NameNotFoundException 
	 * @throws IOException 
	 * @throws NumNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public String getCourierName (String text) throws NameNotFoundException, RemoteException,
	FileNotFoundException, ClassNotFoundException, 
	NumNotFoundException, IOException;

	/**
	 * 得到一批货物的总钱数
	 * @param arrGoods
	 * @return
	 */
	public double getMoneySum(ArrayList<GoodsVO> arrGoods);
	
	/**
	 * 初始化表格
	 * @return
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws NumNotFoundException 
	 */
	public Vector<Object> initTable(String office) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException, NumNotFoundException;
	
	/**
	 * 显示所有银行账户
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException;
	
	/**
	 * 向银行账户中增加钱
	 * @throws AddMoneyInBankException
	 * @throws IOException 
	 * @throws NumNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public void addMoneyInBankAccount(String bankAccount, double money) throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;
	
	/**
	 * 提交
	 * @param vo
	 * @param office
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void submit(ReceiptVO vo, String office) throws NotBoundException, IOException, ClassNotFoundException;
	
}