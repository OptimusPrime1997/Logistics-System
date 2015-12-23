package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRepRefundRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepRefundblService;

public class PayRepRefundController extends PayThingMethods implements PayRepRefundblService{
	
	private Refundbl refundbl = new Refundbl();

	@Override
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO) {
		// TODO Auto-generated method stub
		refundbl.submitRefund(payRepVO, payRepRefundRepVO);
	}

	@Override
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date) {
		// TODO Auto-generated method stub
		return refundbl.initRefundTable(payRepVO, date);
	}

	@Override
	public String getRefundTime(String type) {
		// TODO Auto-generated method stub
		return refundbl.getRefundTime(type);
	}

	@Override
	public PayRepRefundRepVO getRefundByDate(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs, String date){
		// TODO Auto-generated method stub
		return refundbl.getRefundByDate(payRepRefundRepVOs, date);
	}

}
