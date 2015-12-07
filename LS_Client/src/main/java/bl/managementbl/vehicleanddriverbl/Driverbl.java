package bl.managementbl.vehicleanddriverbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import Exception.NumNotFoundException;
import PO.DriverPO;
import VO.ManagementVO.DriverVO;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import util.InputCheck;
import util.enumData.LogType;
import util.enumData.ResultMessage;

public class Driverbl {
	private DriverDataService driverDataService;
	private ManageVOPO manageVOPO;

	public Driverbl() {
		// TODO Auto-generated constructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			driverDataService = (DriverDataService) manageDataService
					.getDriverData();
		} catch (RemoteException e) {
			System.out.println("远程获取driverDataService失败!");
			e.printStackTrace();
		}
		// logbl = new Logbl();
		manageVOPO = ManageVOPO.getInstance();
	}

	public ResultMessage insertDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				try {
					ArrayList<DriverPO> pos = driverDataService.showDriver();
					if (pos != null) {
						for (Iterator<DriverPO> t = pos.iterator(); t.hasNext();) {
							if (t.next().getDriverNum().equals(vo.driverNum)) {
								return ResultMessage.OVERRIDE_DATA;
							}
						}
					}
					ResultMessage rmsg = driverDataService
							.insertDriver(manageVOPO.voToPO(vo));
					ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("存储文件出错");
					return ResultMessage.IOFAILED;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("系统程序错误");
					return ResultMessage.FAILED;
				}
				return ResultMessage.SUCCESS;
			} else {
				System.out.println("司机"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}

	}

	public ResultMessage updateDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				DriverPO po = manageVOPO.voToPO(vo);
				try {
					ResultMessage rmsg = driverDataService.updateDriver(po);
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
				return ResultMessage.SUCCESS;
			} else {
				System.out.println("司机"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage deleteDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			if (InputCheck.checkInputNum(vo.driverNum, 11) == ResultMessage.VALID) {
				DriverPO po = manageVOPO.voToPO(vo);
				try {
					ResultMessage rmsg = driverDataService.deleteDriver(po);
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
				return ResultMessage.SUCCESS;
			} else {
				System.out.println("司机"
						+ InputCheck.checkInputNum(vo.driverNum, 11));
				return ResultMessage.WRONG_DATA;
			}
		} else
			return ResultMessage.FAILED;
	}

	public ArrayList<DriverVO> showDriver() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			ArrayList<DriverPO> pos = driverDataService.showDriver();
			ArrayList<DriverVO> vos = new ArrayList<DriverVO>();
			DriverVO vo;
			for (DriverPO po : pos) {
				vo = manageVOPO.poToVO(po);
				vos.add(vo);
			}
			return vos;
		} else
			throw new RemoteException();
	}

	public DriverVO findByDriverNum(String driverNum)
			throws FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			DriverPO findPO = driverDataService.findByDriverNum(driverNum);
			DriverVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public ResultMessage check(DriverVO vo) {
		if (InputCheck.checkInputName(vo.name) == ResultMessage.VALID) {
			if (InputCheck.checkInputNum(vo.driverNum, 11) == ResultMessage.VALID) {
				if (InputCheck.checkInputPhoneNum(vo.phoneNum) == ResultMessage.VALID) {
					if (InputCheck.checkInputNum(vo.id, 18) == ResultMessage.VALID) {
						if (InputCheck.checkInputDate(vo.licensedTime) == ResultMessage.VALID) {
							return ResultMessage.VALID;
						} else {
							System.out.println("date "
									+ InputCheck
											.checkInputDate(vo.licensedTime));
						}
					} else {
						System.out.println("idnum "
								+ InputCheck.checkInputNum(vo.id, 18));
					}
				} else {
					System.out.println("phoneNum "
							+ InputCheck.checkInputPhoneNum(vo.phoneNum));
				}
			} else {
				System.out.println("drivernum"
						+ InputCheck.checkInputNum(vo.driverNum, 11));
			}
		} else {
			System.out.println("name " + InputCheck.checkInputName(vo.name));
		}
		if (InputCheck.checkInputName(vo.name) == ResultMessage.VALID
				&& InputCheck.checkInputNum(vo.driverNum, 11) == ResultMessage.VALID
				&& InputCheck.checkInputPhoneNum(vo.phoneNum) == ResultMessage.VALID
				&& InputCheck.checkInputNum(vo.id, 18) == ResultMessage.VALID
				&& InputCheck.checkInputDate(vo.licensedTime) == ResultMessage.VALID) {
			return ResultMessage.VALID;
		} else {
			return ResultMessage.WRONG_DATA;
		}
	}
}
