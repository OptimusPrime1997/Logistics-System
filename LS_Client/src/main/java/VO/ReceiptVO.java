package VO;

public class ReceiptVO {
	public String num;
	public String date;
	
	public ReceiptVO(String num, String date) {
		this.num = num;
		this.date = date;
	}
	
	public ReceiptVO(){}			//这有什么用！？不加的话payrepVO的public PayRepVO(PayRepPO po)会报错
		
}
