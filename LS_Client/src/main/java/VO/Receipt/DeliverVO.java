package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.DeliverPO;

public class DeliverVO {
	public String order;
	public String receiverName;
	public String receiverPhone;
	public String address;

	public DeliverVO(String order, String receiverName, String receiverPhone, String address) {
		super();
		this.order = order;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.address = address;
	}

	public DeliverVO(DeliverPO po) {
		this.order = po.getOrder();
		this.receiverName = po.getReceiverName();
		this.receiverPhone = po.getReceiverPhone();
		this.address = po.getAddress();
	}

	public static DeliverPO toPO(DeliverVO vo) {
		if (vo == null)
			return null;
		return new DeliverPO(vo.order, vo.receiverName, vo.receiverPhone, vo.address);
	}

	public static ArrayList<DeliverVO> toArrayVO(ArrayList<DeliverPO> DeliverPOs) {
		if (DeliverPOs == null)
			return null;
		ArrayList<DeliverVO> DeliverVOs = new ArrayList<DeliverVO>();
		for (DeliverPO DeliverPO : DeliverPOs)
			DeliverVOs.add(new DeliverVO(DeliverPO));
		return DeliverVOs;
	}

	public static ArrayList<DeliverPO> toArrayPO(ArrayList<DeliverVO> DeliverVOs) {
		if (DeliverVOs == null)
			return null;
		ArrayList<DeliverPO> DeliverPOs = new ArrayList<DeliverPO>();
		for (DeliverVO DeliverVO : DeliverVOs)
			DeliverPOs.add(toPO(DeliverVO));
		return DeliverPOs;
	}
}
