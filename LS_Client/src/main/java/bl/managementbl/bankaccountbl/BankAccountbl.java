package bl.managementbl.bankaccountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import util.InputCheck;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import PO.BankAccountPO;
import VO.ManagementVO.BankAccountVO;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;

/**
 * @author 1 实现BankAccount的bl逻辑
 */
public class BankAccountbl {
	private BankAccountDataService bankAccountDataService;
	private ManageVOPO manageVOPO;

	public BankAccountbl() {
		// TODO Auto-generated constructor stub
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			bankAccountDataService = (BankAccountDataService) manageDataService
					.getBankAccountData();
		} catch (RemoteException e) {
			System.out.println("远程获取BankAccountDataService失败!");
			e.printStackTrace();
		}
		// logbl = new Logbl();
		manageVOPO = ManageVOPO.getInstance();
	}

	public ResultMessage add(BankAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.BANKACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			ResultMessage rmsg = check(vo);
			if (check(vo) == ResultMessage.VALID) {
				try {
					ArrayList<BankAccountPO> pos = bankAccountDataService
							.show();
					if (pos != null) {
						for (Iterator<BankAccountPO> t = pos.iterator(); t
								.hasNext();) {
							if (t.next().getBankAccountNum()
									.equals(vo.bankAccountNum)) {
								return ResultMessage.EXIST;
							}
						}
					}
					rmsg = bankAccountDataService.insert(manageVOPO.voToPO(vo));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("存储文件出错");
					return ResultMessage.IOFAILED;
				} 
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return rmsg;
		} else
			return ResultMessage.FAILED;
	}

	public ResultMessage update(BankAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.BANKACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			ResultMessage rmsg = check(vo);
			if (check(vo) == ResultMessage.VALID) {
				BankAccountPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = bankAccountDataService.update(po);
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
			}
			return rmsg;
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage delete(BankAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			ResultMessage rmsg = InputCheck
					.checkInputNum(vo.bankAccountNum, 19);
			if (InputCheck.checkInputNum(vo.bankAccountNum, 19) == ResultMessage.VALID) {
				BankAccountPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = bankAccountDataService.delete(po);
					ResultMessage.postCheck(rmsg, ResultMessage.SUCCESS);
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
			}
			return rmsg;
		} else
			return ResultMessage.FAILED;
	}

	public ArrayList<BankAccountVO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.BANKACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			ArrayList<BankAccountPO> pos = bankAccountDataService.show();
			ArrayList<BankAccountVO> vos = new ArrayList<BankAccountVO>();
			BankAccountVO vo;
			for (BankAccountPO po : pos) {
				vo = manageVOPO.poToVO(po);
				vos.add(vo);
			}
			return vos;
		} else
			throw new RemoteException();

	}

	public BankAccountVO findByName(String name) throws FileNotFoundException,
			NameNotFoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.BANKACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			BankAccountPO findPO = bankAccountDataService.findByName(name);
			BankAccountVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public BankAccountVO findByBankAccountNum(String num)
			throws FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		if (bankAccountDataService != null) {
			BankAccountPO findPO = bankAccountDataService
					.findByBankAccountNum(num);
			BankAccountVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public ResultMessage check(BankAccountVO vo) {
		if (InputCheck.checkInputName(vo.bankAccountName) == ResultMessage.VALID) {
			if (InputCheck.checkInputNum(vo.bankAccountNum, 19) == ResultMessage.VALID) {
				if ((vo.balance) >= 0) {
					return ResultMessage.VALID;
				} else {
					return ResultMessage.INPUTNUM_MUST_BE_POSITIVE;
				}
			} else {
				return InputCheck.checkInputNum(vo.bankAccountNum, 19);
			}
		} else {
			return InputCheck.checkInputName(vo.bankAccountName);
		}
	}

}
