package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

import util.enumData.ResultMessage;

public interface ShipmentRepblServce extends ReceiptblService{
	
	public String getTruckSum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException;
	
	public ResultMessage checkDriverNum(String string);
	
	public boolean isTrueAccount(String num);
	
	public boolean isTrueOrder(String order);
	
}
