package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ReceiptVO.PayRepBonusRepVO;
import VO.ReceiptVO.PayRepCourierSalaryRepVO;
import VO.ReceiptVO.PayRepDriverSalaryRepVO;
import VO.ReceiptVO.PayRepFreightRepVO;
import VO.ReceiptVO.PayRepRefundRepVO;
import VO.ReceiptVO.PayRepRentRepVO;
import VO.ReceiptVO.PayRepStaffSalaryRepVO;
import VO.ReceiptVO.PayRepVO;
import util.enumData.PayThing;

public interface PayRepblService extends ReceiptblService{
	
	public Vector<Object> initTable() throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO);
	
	public Vector<Object> initBonusTable(PayRepVO payRepVO);
	
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO);
	
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO);
	
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO);
	
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO);
	
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO);
	
	public Vector<Object> initFreightTable(PayRepVO payRepVO);
	
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO);
	
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date);
	
	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO);
	
	public Vector<Object> initRentTable(PayRepVO payRepVO);
	
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO);
	
	public Vector<Object> initStaffTable(PayRepVO payRepVO);
	
	public String getRefundTime(String type);
	
	public String getReceiverName(String num) throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException, NumNotFoundException, IOException;

	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException;
	
	public void minusMoneyInBankAccount (String bankAccount, double money) throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException;
	
	public double getFreightMoney(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	public PayRepVO getSubmitPayRep() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException;
}
