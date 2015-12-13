package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import util.enumData.Rep;

public interface ReceptionRepblService extends ReceiptblService{
	
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	public void transferOver(String num);
	
	public String getDepart(Rep rep, String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
}
