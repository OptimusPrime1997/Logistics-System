package bl.managementbl.vehicleanddriverbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import Exception.AutoNumException;
import Exception.ExistException;
import Exception.NumNotFoundException;
import PO.DriverPO;
import VO.ManagementVO.DriverVO;
import bl.loginbl.Loginbl;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import util.InputCheck;
import util.ThreeAutoNum;
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

	public String insertDriver(DriverVO vo) throws IOException,
			ClassNotFoundException, AutoNumException, ExistException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				String tempInstitutionNum = null;
				int num = 0;
				ArrayList<DriverPO> pos = driverDataService.showDriver();
				if (pos != null) {
					// pos.sort(null);
					String driverNum = null;
					boolean hasDriver = false;
					String currentOptorId = Loginbl.getCurrentOptorId();

					// 后面进行修改
					// String currentInstitutionNum =
					// currentOptorId.substring(0, 6);
					String currentInstitutionNum = "025010";
					DriverPO po = null;
					if (pos != null) {
						for (Iterator<DriverPO> t = pos.iterator(); t.hasNext();) {
							po = t.next();
							if (po != null) {
								if (po.getId().equals(vo.id)) {
									throw new ExistException();
								}
								if (po.getDriverNum() != null) {
									tempInstitutionNum = po.getDriverNum()
											.substring(0, 6);
									if (tempInstitutionNum
											.equals(currentInstitutionNum)) {
										hasDriver = true;
									}
								}
							}
						}
					}
					driverNum = autoDriverNum(pos, currentInstitutionNum,
							hasDriver);
					DriverPO po2 = manageVOPO.voToPO(vo);
					if (po2 != null) {
						po2.setDriverNum(driverNum);
						ResultMessage rmsg = driverDataService
								.insertDriver(po2);
						ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
						if (rmsg == ResultMessage.SUCCESS) {
							return po.getDriverNum();
						} else {
							throw new AutoNumException();
						}
					} else {
						throw new AutoNumException();
					}
				} else {
					System.out.println("司机"
							+ ResultMessage.toFriendlyString(check(vo)));
				}
			} else {
				throw new RemoteException();
			}
			// DriverPO po2 = manageVOPO.voToPO(vo);
			// ResultMessage rmsg = driverDataService
			// .insertDriver(po2);
			// ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
			// if (rmsg == ResultMessage.SUCCESS) {
			// return po2.getDriverNum();
			// } else {
			// throw new AutoNumException();
			// }
		} else {
			throw new RemoteException();
		}
		return null;
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

	/**
	 * 自动生成司机编号
	 * 
	 * @param pos
	 * @param currentInstitutionNum
	 * @param hasDriver
	 * @return
	 */
	private String autoDriverNum(ArrayList<DriverPO> pos,
			String currentInstitutionNum, boolean hasDriver) {
		DriverPO po = null;
		String tempInstitutionNum = null;
		String driverNum = null;
		if (hasDriver) {
			for (int i = 0; i < pos.size(); i++) {
				po = pos.get(i);
				if (po.getDriverNum().substring(0, 6)
						.equals(currentInstitutionNum)) {
					for (int j = i + 1; j < pos.size();) {
						po = pos.get(j);
						tempInstitutionNum = po.getDriverNum().substring(0, 6);
						if (tempInstitutionNum.equals(currentInstitutionNum)) {
							j++;
						} else {
							driverNum = po.getDriverNum().substring(0, 6)
									+ ThreeAutoNum.toThreeNum(Integer
											.parseInt(po.getDriverNum()
													.substring(6, 9) + 1));
						}
					}
				}
			}
		} else {
			driverNum = currentInstitutionNum + "001";
		}
		return driverNum;
	}
}
