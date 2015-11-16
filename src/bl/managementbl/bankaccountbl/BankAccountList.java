package bl.managementbl.bankaccountbl;

import java.util.ArrayList;

import bl.managementbl.accountbl.AccountLineItem;

public class BankAccountList {
ArrayList<BankAccountLineItem> bankAccountList;
public ArrayList<BankAccountLineItem> getBankAccountList(){
	return bankAccountList;
}
public String addBankAccountLineItem(BankAccountLineItem bankAccountLineItem){
	bankAccountList.add(bankAccountLineItem);
	return null;
}

}
