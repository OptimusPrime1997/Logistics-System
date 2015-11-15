package blservice.receiptblservice;

import java.util.ArrayList;

import VO.TransferRepVO;
import state.ShipForm;

public interface TransferRepblService {
	public TransferRepVO getTransferRep(String num);
	
	public String submit(String num, String date, ShipForm form, String carNum, state.place place, int container,
			boolean arriveAlready, ArrayList<String> goods);
}
