package bl.managementbl.accountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import util.InputCheck;
import util.ThreeAutoNum;
import util.enumData.Authority;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import PO.AccountPO;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.CourierVO;
import bl.managementbl.institutionbl.Institutionbl;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;

public class Accountbl {
	private AccountDataService accountDataService;
	private ManageVOPO manageVOPO;
	private Courierbl courierbl;
	private Institutionbl institutionbl;

	// Logbl logbl;

	public Accountbl() {
		// TODO Auto-generated constructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			accountDataService = (AccountDataService) manageDataService
					.getAccountData();
			courierbl = new Courierbl();
		} catch (RemoteException e) {
			System.out.println("远程获取accountDataService失败!");
			e.printStackTrace();
		}
		// logbl = new Logbl();
		manageVOPO = ManageVOPO.getInstance();
	}

	public ResultMessage add(AccountVO vo) {
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				boolean firstInsert = false;
				try {
					if (vo.accountNum.substring(8, 11).equals("000")) {
						ArrayList<AccountPO> pos = accountDataService.show();
						firstInsert = true;
						AccountPO lastPO = null;
						if (pos != null) {
							for (Iterator<AccountPO> t = pos.iterator(); t
									.hasNext();) {
								AccountPO p = t.next();
								if (p.getPhoneNum().equals(vo.phoneNum)) {
									return ResultMessage.EXIST;
								}
								if (p.getAuthority() == vo.authority) {
									if (p.getInstitutionNum() == vo.institutionNum) {
										lastPO = p;
									}
								}
							}
						}
						if (lastPO == null) {
							vo.accountNum = vo.institutionNum
									+ Authority.value(vo.authority) + "001";
						} else {
							vo.accountNum = vo.institutionNum
									+ Authority.value(vo.authority)
									+ ThreeAutoNum.toThreeNum(Integer
											.parseInt(lastPO.getAccountNum()
													.substring(9)) + 1);
						}
					}
					ResultMessage rmsg = accountDataService.insert(manageVOPO
							.voToPO(vo));
					ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
					if(vo.authority==Authority.COURIER
							&&rmsg==ResultMessage.SUCCESS){
						ResultMessage re=courierbl.add(new CourierVO(vo.accountNum,0));
						System.out.println("添加快递员"+ResultMessage.toFriendlyString(re));
					}
					institutionbl=new Institutionbl();
					ResultMessage r=institutionbl.updateManning(vo.institutionNum);
					System.out.println("更新机构人员信息："+ResultMessage.toFriendlyString(r));
					
					return rmsg;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("存储文件出错");
					return ResultMessage.IOFAILED;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return ResultMessage.FAILED;
				}
			} else
				return ResultMessage.FAILED;
		} else {
			return ResultMessage.REMOTE_FAILED;
		}
	}

	public ResultMessage update(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			ResultMessage rmsg = null;
			if (check(vo) == ResultMessage.VALID) {
				AccountPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = accountDataService.update(po);
					ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("class文件未找到");
					return ResultMessage.FAILED;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("读写文件出错");
					return ResultMessage.IOFAILED;
				}
				return rmsg;
			} else {
				System.out.println("帐户"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage delete(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			ResultMessage rmsg = InputCheck.checkInputNum(vo.accountNum, 11);
			if (InputCheck.checkInputNum(vo.accountNum, 11) == ResultMessage.VALID) {
				AccountPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = accountDataService.delete(po);
					ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
					if (rmsg == ResultMessage.SUCCESS
							&& vo.authority == Authority.COURIER) {
						courierbl.delete(new CourierVO(vo.accountNum, 0));
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("class文件未找到");
					return ResultMessage.FAILED;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("读写文件出错");
					return ResultMessage.IOFAILED;
				}
				return rmsg;
			} else {
				System.out.println("帐户"
						+ InputCheck.checkInputNum(vo.accountNum, 11));
				return ResultMessage.WRONG_ACCOUNTNUM;
			}
		} else
			return ResultMessage.FAILED;
	}

	public ArrayList<AccountVO> show() throws RemoteException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			ArrayList<AccountPO> pos = accountDataService.show();
			ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
			AccountVO vo;
			for (AccountPO po : pos) {
				vo = manageVOPO.poToVO(po);
				vos.add(vo);
			}
			return vos;
		} else
			throw new RemoteException();
	}

	public ArrayList<AccountVO> showOther() throws RemoteException,
			ClassNotFoundException, IOException {
		ArrayList<AccountVO> vos = show();
		if (vos != null) {
			for (int i = 0; i < vos.size(); i++) {
				if (vos.get(i).authority == Authority.COURIER) {
					vos.remove(i);
				}
			}
		}
		assert (vos != null) : ("返回除了快递员的人员的信息为空");
		return vos;
	}

	public AccountVO findByName(String name) throws RemoteException,
			FileNotFoundException, NameNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			AccountPO findPO = accountDataService.findByName(name);
			AccountVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public AccountVO findByAccountNum(String num) throws RemoteException,
			FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			AccountPO findPO = accountDataService.findByAccountNum(num);
			AccountVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public ArrayList<AccountVO> findByInstitutionNum(String institutionNum)
			throws RemoteException, ClassNotFoundException,
			 IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (accountDataService != null) {
			ArrayList<AccountPO> pos = accountDataService
					.findByInstitutionNum(institutionNum);
			if (pos.isEmpty()) {
				throw new NumNotFoundException();
			} else {
				ArrayList<AccountVO> vos = new ArrayList<AccountVO>();
				AccountVO vo = null;
				for (AccountPO po : pos) {
					vo = manageVOPO.poToVO(po);
					vos.add(vo);
				}
				return vos;
			}
		} else {
			throw new RemoteException();
		}
	}

	/**
	 * check login info
	 * 
	 * @param accountNum
	 * @param key
	 * @return.NOT_FOUND;SUCCESS;WRONG_PASSWORD;
	 */
	public ResultMessage login(String accountNum, String key) {
		AccountVO accountVO = null;
		try {
			accountVO = findByAccountNum(accountNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.REMOTE_FAILED;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NOT_FOUND_FILE;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAILED;
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.NOT_COMPLETED_ACCOUNT;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.IOFAILED;
		}
		if (accountVO == null) {
			return ResultMessage.NOT_FOUND;
		} else if (accountVO.password.equals(key)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.WRONG_PASSWORD;
		}
	}

	public ResultMessage check(AccountVO vo) {
		if (InputCheck.checkInputName(vo.accountName) == ResultMessage.VALID) {
			if (InputCheck.checkInputNum(vo.institutionNum, 6) == ResultMessage.VALID) {
				if (InputCheck.checkInputPhoneNum(vo.phoneNum) == ResultMessage.VALID) {
					return ResultMessage.VALID;
				} else {
					return InputCheck.checkInputPhoneNum(vo.phoneNum);
				}
			} else {
				return InputCheck.checkInputNum(vo.institutionNum, 6);
			}
		} else {
			return InputCheck.checkInputName(vo.accountName);
		}
	}
}
