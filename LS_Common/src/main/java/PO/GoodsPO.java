package PO;

import java.io.Serializable;
import java.util.ArrayList;

import util.enumData.*;

public class GoodsPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -234791575811234218L;
	private String listNum;
	private Boolean ifExaminePassed;
	private String getCourierAccount="";
	private String deliverCourierAccount="";
	private String startTime;
	private String overtime="";
	private String destinationCity,startCity;
	private String senderName;
	private String senderAddress;
	private String senderCompany;
	private String senderPhone;
	private String receiverName;
	private String receiverAddress;
	private String receiverCompany;
	private String receiverPhone;
	private int numOfGoods;
	private double weight;
	private double volume;
	private String nameOfInside;
	private GoodsExpressType expressType;
	private double moneyOfPackage;
	private double moneyTotal;
	private double moneyFare;
	private GoodsArrivalState arrivalState;
	private GoodsLogisticState logisticState;
	private String realReceiverName="";
	private String realReceiverPhone="";	
	//物流历史状态
	public String dates="";
	public GoodsPO(String listNum, Boolean ifExaminePassed,
			String getCourierAccount, String deliverCourierAccount,
			String startTime, String overtime, String destinationCity,
			String senderName, String senderAddress, String senderCompany,
			String senderPhone, String receiverName, String receiverAddress,
			String receiverCompany, String receiverPhone, int numOfGoods,
			double weight, double volume, String nameOfInside,
			GoodsExpressType expressType, double moneyOfPackage, double moneyTotal,
			double moneyFare, GoodsArrivalState arrivalState,
			GoodsLogisticState logisticState, String realReceiverName,
			String realReceiverPhone,String dates,String startCity) {
		this.dates=dates;
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
		this.startCity=startCity;
		System.out.println("GoodsPO.dates "+dates);
		
	}

	public String getListNum() {
		return listNum;
	}

	public String getStartCity() {
		return startCity;
	}

	public Boolean getIfExaminePassed() {
		return ifExaminePassed;
	}

	public String getGetCourierAccount() {
		return getCourierAccount;
	}

	public String getDeliverCourierAccount() {
		return deliverCourierAccount;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getOvertime() {
		return overtime;
	}

	public String getDates() {
		return dates;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getReceiverCompany() {
		return receiverCompany;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public int getNumOfGoods() {
		return numOfGoods;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		return volume;
	}

	public String getNameOfInside() {
		return nameOfInside;
	}

	public GoodsExpressType getExpressType() {
		return expressType;
	}

	public double getMoneyOfPackage() {
		return moneyOfPackage;
	}

	public double getMoneyTotal() {
		return moneyTotal;
	}

	public double getMoneyFare() {
		return moneyFare;
	}

	public GoodsArrivalState getArrivalState() {
		return arrivalState;
	}

	public GoodsLogisticState getLogisticState() {
		return logisticState;
	}

	public String getRealReceiverName() {
		return realReceiverName;
	}

	public String getRealReceiverPhone() {
		return realReceiverPhone;
	}

}

