package bl.managementbl.accountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import dataservice.managementdataservice.accountdataservice.AccountDataService;
import util.CurrentTime;
import util.InputCheck;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.AccountPO;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import bl.logbl.Logbl;
import bl.loginbl.Loginbl;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;

public class Accountbl {
	private AccountDataService accountDataService;
	ManageVOPO manageVOPO;
	Logbl logbl;
	public Accountbl() {
		// TODO Auto-generated constructor stub
		super();
		try {
			accountDataService = ManageData.getInstance().getAccountData();
		} catch (RemoteException e) {
			System.out.println("远程获取accountDataService失败!");
			e.printStackTrace();
		}
		logbl=  new Logbl();
		manageVOPO = new ManageVOPO();
	}

	public ResultMessage createLog(LogType operation, String info) {
		Logbl logbl = new Logbl();
		LogVO logVO = new LogVO(operation, Loginbl.getCurrentOptorId(),
				CurrentTime.getTime());
		logbl.add(logVO);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage add(AccountVO vo) throws RemoteException {
		if (accountDataService != null) {
			try {
				accountDataService.insert(manageVOPO.voToPO(vo));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("存储文件出错");
				return ResultMessage.IOFAILED;
			}
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	public ResultMessage update(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		if (accountDataService != null) {
			AccountPO po = manageVOPO.voToPO(vo);
			try {
				accountDataService.update(po);
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

	public ResultMessage delete(AccountVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		if (accountDataService != null) {
			AccountPO po = manageVOPO.voToPO(VO);
			try {
				accountDataService.delete(po);
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

	public ArrayList<AccountVO> show() throws RemoteException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
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

	public AccountVO findByName(String name) throws RemoteException,
			FileNotFoundException, NameNotFoundException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		if (accountDataService != null) {
			AccountPO findPO = accountDataService.findByName(name);
			AccountVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public AccountVO findByAccountNum(String num) throws RemoteException,
			FileNotFoundException, NameNotFoundException,
			ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
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
			NumberFormatException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
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


	public ResultMessage login(String accountNum, String key) {
		AccountVO accountVO = null;
		if (InputCheck.checkInputNum(accountNum, 10) == ResultMessage.WRONG) {
			return ResultMessage.WRONG;
		} else {
			try {
				accountVO = findByAccountNum(accountNum);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (accountVO == null) {
				return ResultMessage.NOT_FOUND;
			} else if (accountVO.password.equals(key)) {
				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.WRONG_PASSWORD;
			}
		}
	}
	
	public ResultMessage addLog(LogType operation) {
		LogVO logVO = new LogVO(operation, Loginbl.getCurrentOptorId(),
				CurrentTime.getTime());
		logbl.add(logVO);
		return ResultMessage.SUCCESS;
	}
}
