package PO;

import java.io.Serializable;

import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsLogisticState;

public class GoodsPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String listNum;
	private Boolean ifExaminePassed;
	private String getCourierAccount;
	private String deliverCourierAccount;
	private String startTime;
	private String overtime;
	private String destinationCity;
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
	private double volume;// Με»ύ
	private String nameOfInside;
	private String expressType;
	private double moneyOfPackage;
	private double moneyTotal;
	private double moneyFare;
	private GoodsArrivalState arrivalState;
	private GoodsLogisticState logisticState;
	private String realReceiverName;
	private String realReceiverPhone;	

	public GoodsPO(String listNum, Boolean ifExaminePassed,
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

	public String getListNum() {
		return listNum;
	}

	public void setListNum(String listNum) {
		this.listNum = listNum;
	}

	public Boolean getIfExaminePassed() {
		return ifExaminePassed;
	}

	public void setIfExaminePassed(Boolean ifExaminePassed) {
		this.ifExaminePassed = ifExaminePassed;
	}

	public String getGetCourierAccount() {
		return getCourierAccount;
	}

	public void setGetCourierAccount(String getCourierAccount) {
		this.getCourierAccount = getCourierAccount;
	}

	public String getDeliverCourierAccount() {
		return deliverCourierAccount;
	}

	public void setDeliverCourierAccount(String deliverCourierAccount) {
		this.deliverCourierAccount = deliverCourierAccount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getOvertime() {
		return overtime;
	}

	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverCompany() {
		return receiverCompany;
	}

	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public int getNumOfGoods() {
		return numOfGoods;
	}

	public void setNumOfGoods(int numOfGoods) {
		this.numOfGoods = numOfGoods;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getNameOfInside() {
		return nameOfInside;
	}

	public void setNameOfInside(String nameOfInside) {
		this.nameOfInside = nameOfInside;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public double getMoneyOfPackage() {
		return moneyOfPackage;
	}

	public void setMoneyOfPackage(double moneyOfPackage) {
		this.moneyOfPackage = moneyOfPackage;
	}

	public double getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}

	public double getMoneyFare() {
		return moneyFare;
	}

	public void setMoneyFare(double moneyFare) {
		this.moneyFare = moneyFare;
	}

	public GoodsArrivalState getArrivalState() {
		return arrivalState;
	}

	public void setArrivalState(GoodsArrivalState arrivalState) {
		this.arrivalState = arrivalState;
	}

	public GoodsLogisticState getLogisticState() {
		return logisticState;
	}

	public void setLogisticDate(GoodsLogisticState logisticState) {
		this.logisticState = logisticState;
	}

	public String getRealReceiverName() {
		return realReceiverName;
	}

	public void setRealReceiverName(String realReceiverName) {
		this.realReceiverName = realReceiverName;
	}

	public String getRealReceiverPhone() {
		return realReceiverPhone;
	}

}

