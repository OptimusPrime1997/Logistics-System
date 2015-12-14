package bl.formbl;

import java.util.ArrayList;

import util.enumData.PayThing;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayVO;
import bl.receiptbl.Receiptbl.ReceiptblController;

public class MockPayRepbl extends ReceiptblController{
	ArrayList<PayRepVO> vos=new ArrayList<PayRepVO>();
	ArrayList<PayVO> payVOs=new ArrayList<PayVO>();
	public ArrayList<PayRepVO> getAllRep() {
		//10,20,30,40,50=150
		for(int i=1;i<6;i++){
			PayRepVO vo=new PayRepVO("1111", "2015-4-7", i*10, payVOs, "4444", null, null, null, null, null, null, null);
			vos.add(vo);
		}
		return vos;
	}
	public ArrayList<PayRepVO> getRepByDate(String tempT) {
		// 10,20,30,40,50=150
		for (int i = 1; i < 6; i++) {
			for(int j=1;j<4;j++){
				/*
				 *5,10,15,
				 *6,12,18,
				 *7,14,21,
				 *8,16,24,
				 *9,18,27,
				 */
				PayVO vo=new PayVO(PayThing.Bonus, i*j, "", "");
				payVOs.add(vo);
			}
			PayRepVO vo = new PayRepVO("111"+i, "2015-4-7", i * 10, payVOs,
					"4444", null, null, null, null, null, null, null);
			vos.add(vo);
		}
		return vos;
	}


}
