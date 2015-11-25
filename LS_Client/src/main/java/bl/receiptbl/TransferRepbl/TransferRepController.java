package bl.receiptbl.TransferRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import VO.ReceptionRepVO;
import VO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.TransferRepblService;
import util.enumData.ResultMessage;

public class TransferRepController extends ReceiptblController implements TransferRepblService{
	TransferRepbl TransferRep = new TransferRepbl();
	
	public ArrayList<ReceptionRepVO> forPay(){
		return TransferRep.forPay();
	}

	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return TransferRep.getTransferRep(num);
	}

	@Override
	public String createNum(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptVO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(CashRepVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashRepVO> getAllCashRep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashRepVO> getRepBydate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
