package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import Exception.GoodsNotFound;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import util.enumData.ResultMessage;

public interface DeliverRepblService extends ReceiptblService{
	public ResultMessage checkCourierNum(String string);
	
	public String getNameByOrder(String order) throws GoodsNotFound;
	
	public String getPhoneByOrder(String order) throws GoodsNotFound;
	
	public String getAddressByOrder(String order) throws GoodsNotFound;
	
	public String getCourierName(String courierNum) throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException,NumNotFoundException, IOException;
}
