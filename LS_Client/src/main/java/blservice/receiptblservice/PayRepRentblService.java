package blservice.receiptblservice;

import java.util.Vector;

import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepRentblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交租金付款单
	 * 
	 * @param payRepVO
	 * @param payRepRentRepVO
	 */
	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO);

	/**
	 * 初始化租金付款单表格
	 * 
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initRentTable(PayRepVO payRepVO);

}
