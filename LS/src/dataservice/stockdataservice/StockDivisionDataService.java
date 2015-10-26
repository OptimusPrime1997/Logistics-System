/**
 * 
 */
package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.StockDivisionVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.OutStockRepVO;

/**
 * @author G
 *
 */
public interface StockDivisionDataService {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public int getInitialNum()throws RemoteException;
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public void initial() throws RemoteException;
	
	/**
	 * update stockData and stockDivisionData
	 * @param rep
	 * @throws RemoteException
	 */
	public void update(InStockRepVO vo) throws RemoteException;
	
	public void update(OutStockRepVO vo) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StockDivisionVO> getStockDivision() throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StockDivisionVO> show() throws RemoteException;
	
	
	
}
