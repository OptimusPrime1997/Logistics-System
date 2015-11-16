package bl.managementbl.institutionbl;

import java.util.ArrayList;

import VO.ManagementVO.BankAccountVO;
import VO.ManagementVO.InstitutionVO;




public class InstitutionList {
	ArrayList<InstitutionVO> institutionList;
	public ArrayList<InstitutionVO> getInstitutionList(){
		return institutionList;
	}
	public String addInstitutionVO(InstitutionVO institutionVO){
		institutionList.add(institutionVO);
		return null;
	}
	public ArrayList<InstitutionVO> getList(){
		return institutionList;
	}
	public int getSize(){
		return  institutionList.size();
	}
		}