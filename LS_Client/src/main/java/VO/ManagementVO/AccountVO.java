package VO.ManagementVO;
import util.enumData.*;

public class AccountVO {
	public String accountNum;
	public String accountName;
	public String password;
	public Sex sex;
	public Authority authority;
	public String phoneNum;
	public String institutionNum;
	
	

	public AccountVO(String accountNum, String accountName,String password,
			Sex sex,Authority authority,String phoneNum,String institution) {
		// TODO Auto-generated constructor stub
		this.accountNum = accountNum;
		this.accountName = accountName;
		this.password=password;
		this.sex=sex;
		this.authority=authority;
		this.phoneNum=phoneNum;
		this.institutionNum=institution;
	}
}