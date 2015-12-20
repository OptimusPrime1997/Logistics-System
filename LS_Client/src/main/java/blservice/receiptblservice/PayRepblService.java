package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.PayRepBonusRepVO;
import VO.Receipt.PayRepCourierSalaryRepVO;
import VO.Receipt.PayRepDriverSalaryRepVO;
import VO.Receipt.PayRepFreightRepVO;
import VO.Receipt.PayRepRefundRepVO;
import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepblService extends ReceiptblService{
		
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
	
	
	
	/**提交奖金付款单
	 * @param payRepVO
	 * @param payRepBonusRepVO
	 */
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO);
	
	/**初始化奖金付款单表格
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initBonusTable(PayRepVO payRepVO);
	
	/**根据人员编号得到奖金获得者名字
	 * @param num
	 * @return
	 * @throws RemoteException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NameNotFoundException
	 * @throws NumNotFoundException
	 * @throws IOException
	 */
	public String getReceiverName(String num) throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException, NumNotFoundException, IOException;
	
	
	
	/**提交快递员付款单
	 * @param payRepVO
	 * @param payRepCourierSalaryRepVO
	 */
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO);
	
	/**初始化快递员付款单表格
	 * @return
	 */
	public Vector<Object> initCourierSalaryTable();
	
	/**初始化快递员付款单检查表格
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO);
	
	
	
	/**提交司机付款单
	 * @param payRepVO
	 * @param payRepDriverSalaryRepVO
	 */
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO);

	/**初始化司机付款单表格
	 * @return
	 */
	public Vector<Object> initDriverSalaryTable();
	
	/**初始化司机付款单检查表格
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO);
	
	
	
	/**提交运费付款单
	 * @param payRepVO
	 * @param payRepFreightRepVO
	 */
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO);
	
	/**初始化运费付款单表格
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public Vector<Object> initFreightTable(String date) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,NotBoundException;

	/**初始化运费付款单检查表格
	 * @param payRepVO
	 * @return
	 * @throws ClassNotFoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws NotBoundException
	 */
	public Vector<Object> initFreightTable(PayRepVO payRepVO) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	
	
	/**提交退款付款单
	 * @param payRepVO
	 * @param payRepRefundRepVO
	 */
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO);
	
	/**初始化退款付款单表格
	 * @param payRepVO
	 * @param date
	 * @return
	 */
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date);
	
	/**得到退款时间
	 * @param type
	 * @return
	 */
	public String getRefundTime(String type);
	
	/**根据时间得到该天的退款付款单
	 * @param payRepRefundRepVOs
	 * @param date
	 * @return
	 */
	public PayRepRefundRepVO getRefundByDate(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs, String date);

	
	
	/**提交租金付款单
	 * @param payRepVO
	 * @param payRepRentRepVO
	 */
	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO);
	
	/**初始化租金付款单表格
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initRentTable(PayRepVO payRepVO);
	
	
	
	/**提交普通员工付款单
	 * @param payRepVO
	 * @param payRepStaffSalaryRepVO
	 */
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO);
	
	/**初始化普通员工付款单表格
	 * @return
	 */
	public Vector<Object> initStaffTable();
	
	/**初始化普通员工付款单检查表格
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initStaffTable(PayRepVO payRepVO);
	
	
	
	/**显示银行账户
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException;
	
	/**从银行账户中减去付款金额
	 * @param bankAccount
	 * @param money
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NumNotFoundException
	 * @throws IOException
	 */
	public void minusMoneyInBankAccount (String bankAccount, double money) throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;
	
}
