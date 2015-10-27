package VO;

import state.ShipForm;
import state.place;

public class TransferRepVO extends ReceiptVO {
	ShipForm form;
	String carNum;
	place place;
	int container;
	boolean arriveAlready;
}
