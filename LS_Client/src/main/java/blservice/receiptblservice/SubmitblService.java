package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

import VO.ReceiptVO.ReceiptVO;

public interface SubmitblService {
	public void submit(ReceiptVO vo) throws NotBoundException, IOException, ClassNotFoundException;
}
