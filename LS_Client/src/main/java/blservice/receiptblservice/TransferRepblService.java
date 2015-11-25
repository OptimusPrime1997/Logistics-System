package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ReceptionRepVO;
import VO.TransferRepVO;

public interface TransferRepblService extends ReceiptblService{
	public TransferRepVO getTransferRep(String num);

	public ArrayList<ReceptionRepVO> forPay();
}
