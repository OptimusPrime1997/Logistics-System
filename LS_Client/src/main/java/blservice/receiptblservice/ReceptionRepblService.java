package blservice.receiptblservice;

import VO.ShipmentRepVO;
import VO.TransferRepVO;
import util.enumData.Rep;

public interface ReceptionRepblService extends ReceiptblService{
	/**
	 * 将到达的中转单或中转中心装车单的属性改为“已到达”
	 * @param rep
	 * @param number
	 * @return
	 */
	public String updateShip (Rep rep, String num);
	
	ShipmentRepVO getShipmentRep(String num);

	TransferRepVO getTransferRep(String num);
}
