package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.TransferRepPO;
import util.enumData.*;

public class TransferRepVO extends ReceiptVO {
	public ShipForm form;
	public String carNum;
	public place place;
	public boolean arriveAlready;
	public ArrayList<String> goods;
	public TransferRepVO(String num, String date, ShipForm form, String carNum, place place,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.place = place;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public TransferRepVO(TransferRepPO po){
		this.form = po.getForm();
		this.carNum = po.getCarNum();
		this.place = po.getPlace();
		this.arriveAlready = po.isArriveAlready();
		this.goods = po.getGoods();
	}
	public static TransferRepPO toPO(TransferRepVO vo){
		return new TransferRepPO(vo.num, vo.date, vo.form, vo.carNum, vo.place, vo.arriveAlready, vo.goods);
	}
}
