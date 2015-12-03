package blservice.receiptblservice;

import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.ShippingRepVO;
import util.enumData.Rep;

public interface GetRepblService extends ReceiptblService{
	/**
	 * 将到达的营业厅装车单或中转中心装车单的属性改为“已到达”
	 * @param rep
	 * @param num
	 * @return
	 */
	public String updateShip (Rep rep, String num);
	
	public ShipmentRepVO getShipmentRep(String num);
	
	public ShippingRepVO getShippingRep(String num);
}
