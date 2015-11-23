package VO;

import java.util.ArrayList;

import PO.GoodsPO;
import util.enumData.*;

public class GoodsVO {
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
	public double volume;// 体积
	public String nameOfInside;
	public GoodsExpressType expressType;
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
			GoodsExpressType expressType, double moneyOfPackage,
			double moneyTotal, double moneyFare,
			GoodsArrivalState arrivalState, GoodsLogisticState logisticState,
			String realReceiverName, String realReceiverPhone) {
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

	public GoodsVO(GoodsPO po){
		this.listNum = po.getListNum();
		this.ifExaminePassed = po.getIfExaminePassed();
		this.getCourierAccount = po.getGetCourierAccount();
		this.deliverCourierAccount = po.getDeliverCourierAccount();
		this.startTime = po.getStartTime();
		this.overtime = po.getOvertime();
		this.destinationCity = po.getDestinationCity();
		this.senderName = po.getSenderName();
		this.senderAddress = po.getSenderAddress();
		this.senderCompany = po.getSenderCompany();
		this.senderPhone = po.getSenderPhone();
		this.receiverName = po.getReceiverName();
		this.receiverAddress = po.getReceiverAddress();
		this.receiverCompany = po.getReceiverCompany();
		this.receiverPhone = po.getReceiverPhone();
		this.numOfGoods = po.getNumOfGoods();
		this.weight = po.getWeight();
		this.volume = po.getVolume();
		this.nameOfInside = po.getNameOfInside();
		this.expressType = po.getExpressType();
		this.moneyOfPackage = po.getMoneyOfPackage();
		this.moneyTotal = po.getMoneyTotal();
		this.moneyFare = po.getMoneyFare();
		this.arrivalState = po.getArrivalState();
		this.logisticState = po.getLogisticState();
		this.realReceiverName = po.getRealReceiverName();
		this.realReceiverPhone = po.getRealReceiverPhone();
		
	}
	public GoodsPO toPO(GoodsVO vo) {
		GoodsPO po = new GoodsPO(listNum, ifExaminePassed, getCourierAccount,
				deliverCourierAccount, startTime, overtime, destinationCity,
				senderName, senderAddress, senderCompany, senderPhone,
				receiverName, receiverAddress, receiverCompany, receiverPhone,
				numOfGoods, weight, volume, nameOfInside, expressType,
				moneyOfPackage, moneyTotal, moneyFare, arrivalState,
				logisticState, realReceiverName, realReceiverPhone);
		return po;
	}
	public static ArrayList<GoodsPO> toPOArray(ArrayList<GoodsVO> vos){
		ArrayList<GoodsPO> pos=new ArrayList<GoodsPO>();
		for(GoodsVO vo:vos){
			pos.add(vo.toPO(vo));
		}
		return pos;
	}
	public static ArrayList<GoodsVO> toVOArray(ArrayList<GoodsPO> pos){
		ArrayList<GoodsVO> vos=new ArrayList<GoodsVO>();
		for(GoodsPO po:pos){
			vos.add(new GoodsVO(po));
		}
		return vos;
	}
}