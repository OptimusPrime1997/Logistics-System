package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import util.enumData.Rep;

public interface OutStockRepblService extends ReceiptblService{

	public Vector<Object> initTable(Rep shipRep, String shipNum) 
			throws ClassNotFoundException, NotBoundException, IOException;
}
