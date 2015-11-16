package bl.goodsbl;

import java.rmi.RemoteException;

import VO.ManagementVO.ConstVO;
import bl.managementbl.constbl.ConstBL;

public class MockConstBL extends ConstBL{
	public ConstVO findByConstName(String constName) throws RemoteException {
		ConstVO vo=new ConstVO(2, 5);
		return vo;
	}


}
