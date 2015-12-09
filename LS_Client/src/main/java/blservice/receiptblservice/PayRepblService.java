package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import VO.ReceiptVO.PayRepBonusRepVO;
import VO.ReceiptVO.PayRepCourierSalaryRepVO;
import VO.ReceiptVO.PayRepDriverSalaryRepVO;
import VO.ReceiptVO.PayRepFreightRepVO;
import VO.ReceiptVO.PayRepRefundRepVO;
import VO.ReceiptVO.PayRepRentRepVO;
import VO.ReceiptVO.PayRepStaffSalaryRepVO;
import VO.ReceiptVO.PayRepVO;

public interface PayRepblService extends ReceiptblService{
	
	public Vector<Object> initTable(String num) throws ClassNotFoundException, NotBoundException, 
	IOException;
	
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
	
}
