package VO;

import java.util.ArrayList;

import PO.GoodsPO;
import util.enumData.*;
/*
 * 010北京 
 * 020广州 
 * 021上海
 * 025南京
 * 
 * GoodsVO vo = new GoodsVO("0250000123", false, "02400100006014",
				"", "20151026", "", "025", "李华",
				"上海市浦东新区张杨路500号", "上海华润时代广场", "87511426", "陆宏",
				"南京市栖霞区仙林大道和园12号", null, "15500001112", 1, 5, 8, "书",
				GoodsExpressType.NORMAL, 5, 0, 0, GoodsArrivalState.INTACT,
				GoodsLogisticState.SENDED, null, null);
 */
public class GoodsVO {
	public String listNum="";
	public Boolean ifExaminePassed=false;
	public String getCourierAccount;
	public String deliverCourierAccount="";
	public String startTime;
	public String overtime="";
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
	public GoodsArrivalState arrivalState=GoodsArrivalState.INTACT;
	public GoodsLogisticState logisticState=GoodsLogisticState.SENDED;
	public String realReceiverName="";
	public String realReceiverPhone="";

	public GoodsVO(String listNum,Boolean ifExaminePassed,
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
		//TODO
		this.listNum=listNum;
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
	public static GoodsPO toPO(GoodsVO vo) {
		GoodsPO po = new GoodsPO(vo.listNum,vo.ifExaminePassed,vo.getCourierAccount,
				vo.deliverCourierAccount,vo.startTime,vo.overtime,vo.destinationCity,
				vo.senderName,vo.senderAddress,vo.senderCompany,vo.senderPhone,
				vo.receiverName,vo.receiverAddress,vo.receiverCompany,vo.receiverPhone,
				vo.numOfGoods,vo.weight,vo.volume,vo.nameOfInside,vo.expressType,
				vo.moneyOfPackage,vo.moneyTotal,vo.moneyFare,vo.arrivalState,
				vo.logisticState,vo.realReceiverName,vo.realReceiverPhone);
		return po;
	}
	public static ArrayList<GoodsPO> toPOArray(ArrayList<GoodsVO> vos){
		ArrayList<GoodsPO> pos=new ArrayList<GoodsPO>();
		for(GoodsVO vo:vos){
			pos.add(toPO(vo));
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