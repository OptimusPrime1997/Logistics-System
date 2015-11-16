package bl.managementbl.institutionbl;

import java.util.ArrayList;




public class InstitutionList {
	ArrayList<InstitutionLineItem> institutionList;
	public ArrayList<InstitutionLineItem> getInstitutionList(){
		return institutionList;
	}
	public String addInstitutionLineItem(InstitutionLineItem institutionLineItem){
		institutionList.add(institutionLineItem);
		return null;
	}
	public int getSize(){
		return  institutionList.size();
	}
		}