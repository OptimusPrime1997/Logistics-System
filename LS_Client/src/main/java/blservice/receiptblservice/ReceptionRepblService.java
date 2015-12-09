package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;
import util.enumData.Rep;

public interface ReceptionRepblService extends ReceiptblService{
	
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders)
			throws ClassNotFoundException, NotBoundException, IOException;
	
	public void transferOver(String num);
}
