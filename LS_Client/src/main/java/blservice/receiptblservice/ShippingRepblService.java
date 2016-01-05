package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ManagementVO.VehicleVO;

/**
 * @author bismuth
 *
 */
public interface ShippingRepblService extends ReceiptblService, GetRepByDateblService, NotForPayblService, NotForCashblService, NotForPayAndCashblService{
	
	/**是否存在该订单
	 * @param order
	 * @return
	 */
	public boolean isTrueOrder(String order);
	
	/**是否存在该账户
	 * @param num
	 * @return
	 */
	public boolean isTrueAccount(String num);
	
	/**检查该车辆是否在该城市
	 * @return
	 */
	public boolean checkVehicle(String vehicle);
}
