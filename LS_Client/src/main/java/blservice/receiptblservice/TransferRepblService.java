package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ReceiptVO.TransferRepVO;

public interface TransferRepblService extends ReceiptblService{
	public ArrayList<TransferRepVO> getByTransNum(String officeNum,String date);
}
