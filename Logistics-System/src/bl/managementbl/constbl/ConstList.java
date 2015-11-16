package bl.managementbl.constbl;

import java.util.ArrayList;

public class ConstList {
	ArrayList<ConstLineItem> constList;

	public ArrayList<ConstLineItem> getConstList() {
		return constList;
	}

	public String addConstLineItem(ConstLineItem constLineItem) {
		constList.add(constLineItem);
		return null;
	}

	public int getSize() {
		return constList.size();
	}

}
