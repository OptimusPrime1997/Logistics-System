package blservice.managementblservice.accountblservice;

import java.util.ArrayList;

import VO.ManagementVO.AccountVO;

public interface AccountBLService {
	public void add(AccountVO vo);
	public void delete(AccountVO vo);
	public void update(AccountVO vo);
	public ArrayList<AccountVO> show();
	public void login(String name,String key);
	public AccountVO findByName(String name);
	public void updateMsg(AccountVO vo);
	public ArrayList<AccountVO> findByIstitutionName(String institution);


	/**
	 * return all the Account of operations in that type,in that part of time
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @return
	 */
	public ArrayList<AccountVO> show(String startTime,String endTime,String type);

}
