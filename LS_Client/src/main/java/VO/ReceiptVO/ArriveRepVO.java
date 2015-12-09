package VO.ReceiptVO;

import java.util.ArrayList;
import util.enumData.Rep;

public class ArriveRepVO extends ReceiptVO{
	public Rep rep;
	public String shipNum;
	public ArrayList<ArriveVO> arriveVOs;
	
	public ArriveRepVO(String num, String date, Rep rep, String shipNum,
			ArrayList<ArriveVO> arriveVOs) {
		super(num, date);
		this.rep = rep;
		this.shipNum = shipNum;
		this.arriveVOs = arriveVOs;
	}
	
	public ArriveRepVO(){
		
	}
	
}
