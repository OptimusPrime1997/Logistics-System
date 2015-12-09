package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

public interface ShipmentRepblServce extends ReceiptblService{
	
	public String getTruckSum(String date) throws ClassNotFoundException, NotBoundException, IOException;
}
