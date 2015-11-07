package bl.receiptbl;

import java.util.ArrayList;

import VO.ReceptionRepVO;
import VO.TransferRepVO;
import blservice.receiptblservice.TransferRepblService;
import state.ShipForm;
import state.place;

public class TransferRepblImpl extends ReceiptRepblImpl implements TransferRepblService{
	public ArrayList<ReceptionRepVO> forPay(){
		return null;
	}

	@Override
	public String submit(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return null;
	}
}
