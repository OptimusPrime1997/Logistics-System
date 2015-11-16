package bl.managementbl.accountbl;

import java.util.ArrayList;

import VO.ManagementVO.AccountVO;

public class AccountList {
	private ArrayList<AccountVO> accountList;
	public AccountList(){
		accountList=new ArrayList<AccountVO>();
	}
	public ArrayList<AccountVO> getAccountList(){
		return accountList;
	}
	public String addAccount(AccountVO accountVO){
		accountList.add(accountVO);
		return null;
	}
	public int getSize(){
		return  accountList.size();
	}
	public ArrayList<AccountVO> getList(){
		return accountList;
	}

}
