package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.TransferRepPO;
import util.enumData.*;

public class TransferRepVO extends ReceiptVO {
	public ShipForm form;
	public String carNum;
	public City City;
	public boolean arriveAlready;
	public ArrayList<String> goods;
	public TransferRepVO(String num, String date, ShipForm form, String carNum, City City,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.City = City;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public TransferRepVO(TransferRepPO po){
		this.form = po.getForm();
		this.carNum = po.getCarNum();
		this.City = po.getCity();
		this.arriveAlready = po.isArriveAlready();
		this.goods = po.getGoods();
	}
	public static TransferRepPO toPO(TransferRepVO vo){
		return new TransferRepPO(vo.num, vo.date, vo.form, vo.carNum, vo.City, vo.arriveAlready, vo.goods);
	}
}
