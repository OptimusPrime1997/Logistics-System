package bl.receiptbl;

import java.util.ArrayList;

import VO.OutStockRepVO;
import blservice.receiptblservice.OutStockRepblService;
import state.ShipForm;
import state.*;

public class OutStackRepblImpl extends ReceiptblImpl implements OutStockRepblService{

	@Override
	public String submit(String num, String date, place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutStockRepVO getbyDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
