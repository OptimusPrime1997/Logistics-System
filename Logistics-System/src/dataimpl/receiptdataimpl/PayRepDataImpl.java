package dataimpl.receiptdataimpl;

import PO.*;

import dataservice.receiptdataservice.PayRepDataService;

public class PayRepDataImpl extends ReceiptDataImpl implements PayRepDataService{

	@Override
	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent) {
		repArray.add(new PayRepPO(num, date, bankAccountNum, payPersonNum, payThings, salary, transferPay, rent));
		return null;
	}
	

}
