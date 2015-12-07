package bl.managementbl.bankaccountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import PO.BankAccountPO;
import PO.ConstPO;
import VO.ManagementVO.BankAccountVO;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;

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
			try {
				ArrayList<BankAccountPO> pos = bankAccountDataService.show();
				if (pos != null) {
					for (Iterator<BankAccountPO> t = pos.iterator(); t.hasNext();) {
						if (t.next().getBankAccountNum().equals(vo.bankAccountNum)) {
							return ResultMessage.EXIST;
						}
					}
				}
				bankAccountDataService.insert(manageVOPO.voToPO(vo));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("存储文件出错");
				return ResultMessage.IOFAILED;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	public ResultMessage update(BankAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.BANKACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			BankAccountPO po = manageVOPO.voToPO(vo);
			try {
				bankAccountDataService.update(po);
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
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage delete(BankAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (bankAccountDataService != null) {
			BankAccountPO po = manageVOPO.voToPO(vo);
			try {
				bankAccountDataService.delete(po);
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
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	public ArrayList<BankAccountVO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
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

}
