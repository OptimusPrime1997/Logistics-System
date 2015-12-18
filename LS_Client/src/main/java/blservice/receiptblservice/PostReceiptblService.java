package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;

public interface PostReceiptblService {

	public <T extends ReceiptVO> ArrayList<T> getAllRep(String office) throws NotBoundException, ClassNotFoundException, IOException;
	
	public <T extends ReceiptVO> ArrayList<T> getRepByDate(String date, String office) throws NotBoundException, ClassNotFoundException, IOException;
	
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException, NameNotFoundException, NumNotFoundException;
}
