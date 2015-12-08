package VO.ManagementVO;

import util.enumData.ModifyState;

public class BankAccountVOPlus extends BankAccountVO {
	public ModifyState isModify;

	public BankAccountVOPlus(String bankAccountNum, String bankAccountName,
			double balance, ModifyState isModify) {
		super(bankAccountNum, bankAccountName, balance);
		// TODO Auto-generated constructor stub
		this.isModify = isModify;
	}

	public BankAccountVOPlus(BankAccountVO v, ModifyState isModify) {
		super(v.bankAccountNum, v.bankAccountName, v.balance);
		this.isModify = isModify;
	}

	public BankAccountVO getBankAccountVO() {
		return new BankAccountVO(bankAccountNum, bankAccountName, balance);
	}

}
