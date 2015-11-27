package blservice.receiptblservice;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.GoodsVO;
import Exception.NameNotFoundException;

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
	 */
	public String getCourierName (String text) throws NameNotFoundException, RemoteException;

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
	 */
	public Vector<Object> initTable(String date) throws RemoteException, MalformedURLException, NotBoundException;
	
}