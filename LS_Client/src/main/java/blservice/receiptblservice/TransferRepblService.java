package blservice.receiptblservice;

import Exception.GoodsNotFound;
import util.enumData.ShipForm;

public interface TransferRepblService extends ReceiptblService{
	public boolean isTrueOrder(String order);
	
	public double getFreightMoney(String depart, String destination, double weight, ShipForm form);
	
	public double getWeightByOrder(String order) throws GoodsNotFound;
}
