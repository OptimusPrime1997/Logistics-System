package blservice.receiptblservice;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import util.enumData.*;

public interface ReceiptblService extends PreReceiptblService{
	
	public String createNum(String date);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
	
	public ReceiptVO getRepByNum(String num);
	
	public ResultMessage submit(CashRepVO vo);
	
	public ArrayList<CashRepVO> getAllCashRep();
	
	public ArrayList<CashRepVO> getRepBydate(String date);
}
