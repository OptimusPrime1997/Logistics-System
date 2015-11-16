package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ReceptionRepVO;
import VO.TransferRepVO;
import util.enumData.ShipForm;

public interface TransferRepblService {
	public TransferRepVO getTransferRep(String num);
	
	public String submit(String num, String date, ShipForm form, String carNum, util.enumData.place place, int container,
			boolean arriveAlready, ArrayList<String> goods);

	public ArrayList<ReceptionRepVO> forPay();
}
