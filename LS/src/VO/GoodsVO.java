package VO;

import java.io.Serializable;

import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsLogisticState;

public class GoodsVO  {
	public String listNum;
	public Boolean ifExaminePassed;
	public String getCourierAccount;
	public String deliverCourierAccount;
	public String startTime;
	public String overtime;
	public String destinationCity;
	public String senderName;
	public String senderAddress;
	public String senderCompany;
	public String senderPhone;
	public String receiverName;
	public String receiverAddress;
	public String receiverCompany;
	public String receiverPhone;
	public int numOfGoods;
	public double weight;
	public double volume;// Με»ύ
	public String nameOfInside;
	public String expressType;
	public double moneyOfPackage;
	public double moneyTotal;
	public double moneyFare;
	public GoodsArrivalState arrivalState;
	public GoodsLogisticState logisticState;
	public String realReceiverName;
	public String realReceiverPhone;	

	public GoodsVO(String listNum, Boolean ifExaminePassed,
			String getCourierAccount, String deliverCourierAccount,
			String startTime, String overtime, String destinationCity,
			String senderName, String senderAddress, String senderCompany,
			String senderPhone, String receiverName, String receiverAddress,
			String receiverCompany, String receiverPhone, int numOfGoods,
			double weight, double volume, String nameOfInside,
			String expressType, double moneyOfPackage, double moneyTotal,
			double moneyFare, GoodsArrivalState arrivalState,
			GoodsLogisticState logisticState, String realReceiverName,
			String realReceiverPhone) {
		this.listNum = listNum;
		this.ifExaminePassed = ifExaminePassed;
		this.getCourierAccount = getCourierAccount;
		this.deliverCourierAccount = deliverCourierAccount;
		this.startTime = startTime;
		this.overtime = overtime;
		this.destinationCity = destinationCity;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderCompany = senderCompany;
		this.senderPhone = senderPhone;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverCompany = receiverCompany;
		this.receiverPhone = receiverPhone;
		this.numOfGoods = numOfGoods;
		this.weight = weight;
		this.volume = volume;
		this.nameOfInside = nameOfInside;
		this.expressType = expressType;
		this.moneyOfPackage = moneyOfPackage;
		this.moneyTotal = moneyTotal;
		this.moneyFare = moneyFare;
		this.arrivalState = arrivalState;
		this.logisticState = logisticState;
		this.realReceiverName = realReceiverName;
		this.realReceiverPhone = realReceiverPhone;
	}
}