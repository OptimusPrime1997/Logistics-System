package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepCourierSalaryRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepCourierblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交快递员付款单
	 * 
	 * @param payRepVO
	 * @param payRepCourierSalaryRepVO
	 */
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO);

	/**
	 * 初始化快递员付款单表格
	 * 
	 * @return
	 * @throws NumNotFoundException
	 * @throws IOException
	 * @throws SalaryPolicyNotFoundException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 */
	public Vector<Object> initCourierSalaryTable() throws FileNotFoundException, ClassNotFoundException,
			SalaryPolicyNotFoundException, IOException, NumNotFoundException;

	/**
	 * 初始化快递员付款单检查表格
	 * 
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO);

}
