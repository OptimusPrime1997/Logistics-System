package bl.managementbl.bankaccountbl;

import java.util.ArrayList;

import VO.ManagementVO.AccountVO;
import VO.ManagementVO.BankAccountVO;


public class BankAccountList {
ArrayList<BankAccountVO> bankAccountList;

public BankAccountList() {
	super();
	bankAccountList=new ArrayList<BankAccountVO>();
}
public ArrayList<BankAccountVO> getBankAccountList(){
	return bankAccountList;
}
public String addBankAccountVO(BankAccountVO bankAccountVO){
	bankAccountList.add(bankAccountVO);
	return null;
}
public int getSize(){
	return  bankAccountList.size();
}
public ArrayList<BankAccountVO> getList(){
	return bankAccountList;
}

}
