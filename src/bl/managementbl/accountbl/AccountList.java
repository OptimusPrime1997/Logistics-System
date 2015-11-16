package bl.managementbl.accountbl;

import java.util.ArrayList;

public class AccountList {
	private ArrayList<AccountLineItem> accountList;
	public ArrayList<AccountLineItem> getAccountList(){
		return accountList;
	}
	public String addAccountLineItem(AccountLineItem accountLineItem){
		accountList.add(accountLineItem);
		return null;
	}
	public int getSize(){
		return  accountList.size();
	}

}
