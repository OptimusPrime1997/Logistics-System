package bl.managementbl.constbl;
import java.rmi.RemoteException;

import util.enumData.Const;
import util.enumData.ResultMessage;
import VO.ManagementVO.ConstVO;
public class Constbl {
	public ResultMessage createLog(String content){	
		MockLog log = new MockLog(content);
		return log.add();		
	}
	public ConstVO findByConstName(Const constName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
