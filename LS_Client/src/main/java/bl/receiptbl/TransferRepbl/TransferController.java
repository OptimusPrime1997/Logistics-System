package bl.receiptbl.TransferRepbl;

import java.util.ArrayList;

import VO.ReceptionRepVO;
import VO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.TransferRepblService;
import util.enumData.ShipForm;
import util.enumData.place;

public class TransferController extends ReceiptController implements TransferRepblService{
	TransferRepbl TransferRep = new TransferRepbl();
	
	public ArrayList<ReceptionRepVO> forPay(){
		return TransferRep.forPay();
	}

	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return TransferRep.getTransferRep(num);
	}

	public String submit(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return TransferRep.submit(num, date, form, carNum, place, container, arriveAlready, goods);
	}
}
