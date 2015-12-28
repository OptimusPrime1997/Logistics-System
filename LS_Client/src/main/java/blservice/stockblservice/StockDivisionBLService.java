/**
 * 支持界面的手动分区以及提供可用区位
 */
package blservice.stockblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.City;
import util.enumData.ResultMessage;
import VO.StockDivisionVO;

/**
 * @author G
 *
 */
public interface StockDivisionBLService {
	
	/**
	 * 界面提供旧的区号和位号，新的区号和位号，系统将旧的区位号变成新的区位号
	 * @param oldBlock
	 * @param oldPlace
	 * @param newBlock
	 * @param newPlace
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	
	public ResultMessage modifyDivision(int oldBlock, int oldPlace, int newBlock, int newPlace) throws MalformedURLException, RemoteException, NotBoundException, ClassNotFoundException, IOException;
	
	/**
	 * 界面提供目的地，系统提供该仓库该目的地已有的区号和位号
	 * @param destination
	 * @return
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 * @throws IOException 
	 */
	public ArrayList<StockDivisionVO> getBlock(City destination) throws MalformedURLException, RemoteException, NotBoundException, IOException;

	/**
	 * 界面提供区号，系统提供该仓库该区的已有区位
	 * @param block
	 * @return
	 * @throws  
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 * @throws IOException 
	 */
	public ArrayList<StockDivisionVO> getBlockByDivision(int block) throws MalformedURLException, RemoteException, NotBoundException, IOException;
}
