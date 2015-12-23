package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.PayRepVO;
import util.enumData.ResultMessage;

/**
 * @author bismuth
 *
 */
public interface PayRepblService extends ReceiptblService, NotForCashblService{
		
	/** 初始化付款单表格
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public Vector<Object> initTable() throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	/**得到未完成的付款单
	 * @return
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public PayRepVO getSubmitPayRep() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	/**初始化付款单检查表格
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 */
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException;
	
	/**自动填写当前付款人 
	 * @return
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NumNotFoundException
	 * @throws IOException
	 */
	public String payPeople() throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;
	
}
