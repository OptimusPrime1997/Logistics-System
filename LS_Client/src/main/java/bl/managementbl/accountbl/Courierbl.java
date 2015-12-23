package bl.managementbl.accountbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.InputCheck;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.CourierPO;
import VO.ManagementVO.CourierVO;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import dataservice.managementdataservice.accountdataservice.CourierDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;

public class Courierbl {
	private CourierDataService courierDataService;
	private ManageVOPO manageVOPO;

	// Logbl logbl;

	public Courierbl() {
		// TODO Auto-generated constructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			courierDataService = (CourierDataService) manageDataService
					.getCourierData();
		} catch (RemoteException e) {
			System.out.println("远程获取courierDataService失败!");
			e.printStackTrace();
		}
		// logbl = new Logbl();
		manageVOPO = ManageVOPO.getInstance();
	}

	public ResultMessage add(CourierVO vo) {
		if (courierDataService != null) {
			ResultMessage rmsg = check(vo);
			if (rmsg == ResultMessage.VALID) {
				try {
					rmsg = courierDataService.insert(manageVOPO.voToPO(vo));
					ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("存储文件出错");
					return ResultMessage.IOFAILED;
				}
			}
			return rmsg;
		} else {
			return ResultMessage.REMOTE_FAILED;
		}
	}

	public ResultMessage update(CourierVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (courierDataService != null) {
			ResultMessage rmsg = check(vo);
			if (check(vo) == ResultMessage.VALID) {
				CourierPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = courierDataService.update(po);
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
				System.out.println("快递员"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	/**
	 * @param courierNum
	 * @param amount
	 * @return
	 */
	public ResultMessage updateMoney(String courierNum, double amount) {
		ResultMessage rmsg = null;
		CourierVO vo = null;
		try {
			vo = findByCourierNum(courierNum);
			vo.courrentMonthMoney += amount;
			rmsg = update(vo);
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
			return ResultMessage.NOT_FOUND_ACCOUNTNUM;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.IOFAILED;
		}
		return rmsg;
	}

	public ResultMessage delete(CourierVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (courierDataService != null) {
			ResultMessage rmsg = InputCheck.checkInputNum(vo.courierNum, 11);
			if (InputCheck.checkInputNum(vo.courierNum, 11) == ResultMessage.VALID) {
				CourierPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = courierDataService.delete(po);
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
				System.out.println("快递员"
						+ InputCheck.checkInputNum(vo.courierNum, 11));
				return ResultMessage.WRONG_ACCOUNTNUM;
			}
		} else
			return ResultMessage.FAILED;
	}

	public ArrayList<CourierVO> show() throws RemoteException,
			ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (courierDataService != null) {
			ArrayList<CourierPO> pos = courierDataService.show();
			ArrayList<CourierVO> vos = new ArrayList<CourierVO>();
			CourierVO vo;
			for (CourierPO po : pos) {
				vo = manageVOPO.poToVO(po);
				vos.add(vo);
			}
			return vos;
		} else
			throw new RemoteException();
	}

	public CourierVO findByCourierNum(String num) throws RemoteException,
			FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.USER_ACCOUNT_MANAGEMENT);
		if (courierDataService != null) {
			CourierPO findPO = courierDataService.findByCourierNum(num);
			CourierVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public ResultMessage check(CourierVO vo) {
		if (InputCheck.checkInputNum(vo.courierNum, 11) == ResultMessage.VALID) {
			if (vo.courrentMonthMoney >= 0) {
				return ResultMessage.VALID;
			} else {
				return ResultMessage.INPUTNUM_MUST_BE_POSITIVE;
			}
		} else {
			return InputCheck.checkInputNum(vo.courierNum, 11);
		}
	}
}
