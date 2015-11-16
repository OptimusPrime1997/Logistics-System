package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import VO.ShippingRepVO;
import util.enumData.Rep;
import util.enumData.goodsState;

public interface GetRepblService extends ReceiptblService{
	/**
	 * 将到达的营业厅装车单或中转中心装车单的属性改为“已到达”
	 * @param rep
	 * @param num
	 * @return
	 */
	public String updateShip (Rep rep, String num);
	
	public String submit(String num, String date, String shipNum, util.enumData.place place, goodsState state,
			ArrayList<String> goods);
	
	public ShipmentRepVO getShipmentRep(String num);
	
	public ShippingRepVO getShippingRep(String num);
}
