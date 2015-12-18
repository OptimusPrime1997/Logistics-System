package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;

public interface ReceiptblService extends PreReceiptblService{
	
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException;
	
	public <T extends ReceiptVO> T getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException;
	
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
}
