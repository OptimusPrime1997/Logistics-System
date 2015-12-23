package blservice.receiptblservice;

import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRepRefundRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepRefundblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交退款付款单
	 * 
	 * @param payRepVO
	 * @param payRepRefundRepVO
	 */
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO);

	/**
	 * 初始化退款付款单表格
	 * 
	 * @param payRepVO
	 * @param date
	 * @return
	 */
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date);

	/**
	 * 得到退款时间
	 * 
	 * @param type
	 * @return
	 */
	public String getRefundTime(String type);

	/**
	 * 根据时间得到该天的退款付款单
	 * 
	 * @param payRepRefundRepVOs
	 * @param date
	 * @return
	 */
	public PayRepRefundRepVO getRefundByDate(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs, String date);

}
