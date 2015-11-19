package bl.receiptbl.TransferRepbl;

import java.util.ArrayList;

import VO.ReceptionRepVO;
import VO.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.ShipForm;
import util.enumData.place;

public class TransferRepbl extends Receiptbl{
	
	public ArrayList<ReceptionRepVO> forPay(){
		return null;
	}

	public String submit(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return null;
	}
}
