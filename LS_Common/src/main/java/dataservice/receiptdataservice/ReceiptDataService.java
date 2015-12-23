package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import util.enumData.Rep;

/**
 * @author bismuth
 *
 */
public interface ReceiptDataService extends Remote, Serializable{
	
	/**提交
	 * @param po
	 * @param rep
	 * @throws IOException
	 * @throws RemoteException
	 */
	public void submit(ReceiptPO po, Rep rep) throws IOException, RemoteException;
	
	/**保存
	 * @param po
	 * @param rep
	 * @throws IOException
	 * @throws RemoteException
	 */
	public void save(ReceiptPO po, Rep rep) throws IOException, RemoteException;
	
	/**根据单据类型和工作地点得到所有已保存的单据
	 * @param rep
	 * @param office
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws RemoteException
	 */
	public ArrayList<ReceiptPO> getAllRep(Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	/**根据日期，单据类型和工作地点得到所有已保存的单据
	 * @param date
	 * @param rep
	 * @param office
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws RemoteException
	 */
	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	/**根据单据编号和单据类型得到一个已保存的单据
	 * @param num
	 * @param rep
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws NumNotFoundException
	 */
	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException, RemoteException, NumNotFoundException;
	
	/**自动生成编号
	 * @param date
	 * @param rep
	 * @param office
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws RemoteException
	 */
	public String createNum(String date, Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	/**清空某个工作地点的某种已提交的单据
	 * @param rep
	 * @param office
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void clearSubmit(Rep rep, String office) throws IOException, ClassNotFoundException, RemoteException;
	
	/**清空某个工作地点的某种已保存的单据
	 * @param rep
	 * @param office
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void clearSave(Rep rep, String office) throws IOException, ClassNotFoundException, RemoteException;
	
	/**得到某个工作地点的某种已提交的单据
	 * @param rep
	 * @param office
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ReceiptPO getSubmitRep(Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	/**得到某种单据类型所有单据
	 * @param rep
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ArrayList<ReceiptPO> forCheck(Rep rep) throws ClassNotFoundException, IOException, RemoteException;

	/**将某个单据从提交文件转移到保存文件
	 * @param num
	 * @param rep
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	void submitSave(String num, Rep rep) throws ClassNotFoundException, IOException, RemoteException;
	
}