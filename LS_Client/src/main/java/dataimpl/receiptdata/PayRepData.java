package dataimpl.receiptdata;

import PO.*;

import dataservice.receiptdataservice.PayRepDataService;

public class PayRepData extends ReceiptData implements PayRepDataService{

	@Override
	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent) {
		repArray.add(new PayRepPO(payPersonNum, payPersonNum, payPersonNum, payPersonNum, null, null, null, null));
		return null;
	}
	

}
