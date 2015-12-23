package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepDriverSalaryRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepDriverblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交司机付款单
	 * 
	 * @param payRepVO
	 * @param payRepDriverSalaryRepVO
	 */
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO);

	/**
	 * 初始化司机付款单表格
	 * 
	 * @return
	 * @throws NumNotFoundException
	 * @throws IOException
	 * @throws SalaryPolicyNotFoundException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public Vector<Object> initDriverSalaryTable() throws FileNotFoundException, ClassNotFoundException,
			SalaryPolicyNotFoundException, IOException, NumNotFoundException;

	/**
	 * 初始化司机付款单检查表格
	 * 
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO);

}
