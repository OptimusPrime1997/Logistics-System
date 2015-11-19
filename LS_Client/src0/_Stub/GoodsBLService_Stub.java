/**
 * 
 */
package _Stub;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.goodsbl.GoodsArrivalState;
import bl.goodsbl.GoodsExpressType;
import bl.goodsbl.GoodsLogisticState;
import blservice.goodsblservice.GoodsBLService;

/**
 * @author G
 *
 */
public  class GoodsBLService_Stub implements GoodsBLService{
	
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
	public double volume;// ���
	public String nameOfInside;
	public GoodsExpressType expressType;
	public double moneyOfPackage;
	public double moneyTotal;
	public double moneyFare;
	public GoodsArrivalState arrivalState;
	public GoodsLogisticState logisticState;
	public String realReceiverName;
	public String realReceiverPhone;	

	public GoodsVO vo;
	
	@Override
	public GoodsVO check(String listNum) {
		// TODO Auto-generated method stub
		System.out.println("Goods Check Success!~");
		return vo;
	}

	
	@Override
	public GoodsVO init(GoodsVO vo) {
		this.listNum=vo.listNum;
		this.startTime=vo.startTime;
		this.senderName=vo.senderName;
		this.senderAddress=vo.senderAddress;
		this.senderCompany=vo.senderCompany;
		this.senderPhone=vo.senderPhone;
		this.receiverName=vo.realReceiverName;
		this.receiverAddress=vo.receiverAddress;
		this.receiverCompany=vo.receiverCompany;
		this.receiverPhone=vo.receiverPhone;
		this.numOfGoods=vo.numOfGoods;
		this.weight=vo.weight;
		this.volume=vo.volume;
		this.nameOfInside=vo.nameOfInside;
		this.expressType=expressType;
		this.moneyOfPackage=vo.moneyOfPackage;
		// TODO Auto-generated method stub
		System.out.println("Initial list success!~");
		return vo;
	}

	
	@Override
	public Boolean delete(GoodsVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Delete list success!~");
		return true;
	}

	
	@Override
	public ArrayList<GoodsVO> getGoodsByCourier(String CourierNum) {
		System.out.println("getGoodsByCourier success!~");
		// TODO Auto-generated method stub
		ArrayList<GoodsVO> lists=new ArrayList<GoodsVO>();
		GoodsVO list=vo;
		lists.add(list);
		return lists;
	}

	
	@Override
	public Boolean setArrivalState(String listNum, GoodsArrivalState state) {
		// TODO Auto-generated method stub
		System.out.println("SetArrivalState success!~");
		return true;
	}

	
	@Override
	public Boolean setLogisticState(String listNum, GoodsLogisticState state) {
		// TODO Auto-generated method stub
		System.out.println("SetLogisticState success!~");
		return true;
	}

	
	@Override
	public void examine(String listNum, Boolean ifPassed) {
		// TODO Auto-generated method stub
		System.out.println("Examined!~");
	}


	@Override
	public ArrayList<GoodsVO> getGoodsByGetCourier(String CourierNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
