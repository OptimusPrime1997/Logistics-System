package bl.formbl;

import java.util.ArrayList;

import VO.CashRepVO;
import bl.receiptbl.CashRepbl.CashRepbl;

public class MockCashRep extends CashRepbl {
	public ArrayList<CashRepVO> get() {
		ArrayList<CashRepVO> vos = new ArrayList<CashRepVO>();
		CashRepVO vo1=new CashRepVO();vo1.money=1000;vos.add(vo1);
		CashRepVO vo2=new CashRepVO();vo2.money=1000;vos.add(vo2);
		CashRepVO vo3=new CashRepVO();vo3.money=1000;vos.add(vo3);
		CashRepVO vo4=new CashRepVO();vo4.money=1000;vos.add(vo4);
		
		return vos;
	}
}
