package bl.managementbl.constbl;

import java.util.ArrayList;

import VO.ManagementVO.BankAccountVO;
import VO.ManagementVO.ConstVO;

public class ConstList {
	ArrayList<ConstVO> constList;

	public ArrayList<ConstVO> getConstList() {
		return constList;
	}

	public String addConstVO(ConstVO ConstVO) {
		constList.add(ConstVO);
		return null;
	}
	public ArrayList<ConstVO> getList(){
		return constList;
	}
	public int getSize() {
		return constList.size();
	}

}
