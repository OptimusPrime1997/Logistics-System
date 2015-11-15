package VO.ManagementVO;
import util.enumData.*;

public class AccountVO {
	private String accountNum;
	private String accountName;
	private String password;
	private Sex sex;
	private Authority authority;
	private String phoneNum;
	private String institution;
	
	

	public AccountVO(String accountNum, String accountName,String password,
			Sex sex,Authority authority,String phoneNum,String institution) {
		// TODO Auto-generated constructor stub
		this.accountNum = accountNum;
		this.accountName = accountName;
		this.password=password;
		this.sex=sex;
		this.authority=authority;
		this.phoneNum=phoneNum;
		this.institution=institution;
	}
}