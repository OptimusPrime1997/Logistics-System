package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepStaffblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交普通员工付款单
	 * 
	 * @param payRepVO
	 * @param payRepStaffSalaryRepVO
	 */
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO);

	/**
	 * 初始化普通员工付款单表格
	 * 
	 * @return
	 * @throws NumNotFoundException
	 * @throws IOException
	 * @throws SalaryPolicyNotFoundException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public Vector<Object> initStaffTable() throws FileNotFoundException, ClassNotFoundException,
			SalaryPolicyNotFoundException, IOException, NumNotFoundException;

	/**
	 * 初始化普通员工付款单检查表格
	 * 
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initStaffTable(PayRepVO payRepVO);

}
