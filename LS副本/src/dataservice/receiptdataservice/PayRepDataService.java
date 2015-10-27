package dataservice.receiptdataservice;

public interface PayRepDataService {
	public String submit(String num, String date, String bankAccountNum, String payPersonNum, String[] payThings,
			String[] salary, String[] transferPay, String[] rent);
}
