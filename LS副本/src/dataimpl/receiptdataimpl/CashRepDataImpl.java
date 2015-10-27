package dataimpl.receiptdataimpl;

import java.util.ArrayList;

import PO.*;
import VO.GoodsVO;
import dataservice.receiptdataservice.CashRepDataService;

public class CashRepDataImpl extends ReceiptDataImpl implements CashRepDataService{

	public String submit(String num, String date, int money, String getCourierNum, ArrayList<GoodsVO> goods) {
		repArray.add(new CashRepPO(num,date,money,getCourierNum,goods));
		return null;
	}
}
