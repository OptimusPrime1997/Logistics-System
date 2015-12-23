package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import VO.Receipt.PayRepFreightRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepFreightblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交运费付款单
	 * 
	 * @param payRepVO
	 * @param payRepFreightRepVO
	 */
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO);

	/**
	 * 初始化运费付款单表格
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public Vector<Object> initFreightTable(String date) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;

	/**
	 * 初始化运费付款单检查表格
	 * 
	 * @param payRepVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public Vector<Object> initFreightTable(PayRepVO payRepVO);
}
