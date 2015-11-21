package bl.goodsbl;

import java.rmi.RemoteException;

import VO.ManagementVO.ConstVO;
import bl.managementbl.constbl.Constbl;

public class MockConstBL extends Constbl{
	public ConstVO findByConstName(String constName) throws RemoteException {
		ConstVO vo=new ConstVO(constName, 2, 5);
		return vo;
	}


}
