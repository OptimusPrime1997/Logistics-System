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

	public ResultMessage insertDriver(DriverVO vo) {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			ResultMessage rmsg = check(vo);
			DriverPO lastPO = null;
			if (check(vo) == ResultMessage.VALID) {
				try {
					ArrayList<DriverPO> pos = driverDataService.showDriver();
					if (vo.driverNum.substring(8, 11).equals("000")) {
						String temp = vo.driverNum.substring(0, 6);
						if (pos != null) {
							for (Iterator<DriverPO> t = pos.iterator(); t
									.hasNext();) {
								DriverPO p = t.next();
								if (p.getId().equals(vo.id)) {
									return ResultMessage.EXIST;
								}
								if (p.getDriverNum().substring(0, 6)
										.equals(temp)) {
									lastPO = p;
								}
							}
						}
						if (lastPO == null) {
							vo.driverNum = vo.driverNum.substring(0, 6) + "07"
									+ "001";
						} else {
							vo.driverNum = vo.driverNum.substring(0, 6)
									+ "07"
									+ ThreeAutoNum.toThreeNum(Integer
											.parseInt(lastPO.getDriverNum()
													.substring(8, 11)) + 1);
						}
					}
					rmsg = driverDataService
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
				}
				return rmsg;
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
				ResultMessage rmsg = InputCheck.checkInputNum(vo.driverNum, 11);
				if (InputCheck.checkInputNum(vo.driverNum, 11) == ResultMessage.VALID) {
					DriverPO po = manageVOPO.voToPO(vo);
					try {
						rmsg = driverDataService.updateDriver(po);
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
				}
				return rmsg;
			} else {
				System.out.println("司机"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage addNumber(String driverNum) {
		ResultMessage rmsg = null;
		DriverVO vo = null;
		try {
			vo = findByDriverNum(driverNum);
			vo.number += 1;
			rmsg = updateDriver(vo);
		} catch (FileNotFoundException e) {
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
		return rmsg;
	}

	public ResultMessage deleteDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DRIVER_MANAGEMENT);
		if (driverDataService != null) {
			ResultMessage rmsg = InputCheck.checkInputNum(vo.driverNum, 11);
			if (InputCheck.checkInputNum(vo.driverNum, 11) == ResultMessage.VALID) {
				DriverPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = driverDataService.deleteDriver(po);
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
				System.out.println("delete driver:" + rmsg);
				return rmsg;
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
		DriverPO po2 = null;
		String tempInstitutionNum = null;
		String driverNum = null;
		if (hasDriver) {
			for (int i = 0; i < pos.size(); i++) {
				po = pos.get(i);
				if (po.getDriverNum().substring(0, 6)
						.equals(currentInstitutionNum)) {
					for (int j = i; j < pos.size();) {
						po2 = pos.get(j);
						tempInstitutionNum = po2.getDriverNum().substring(0, 6);
						if (tempInstitutionNum.equals(currentInstitutionNum)) {
							j++;
						} else {
							driverNum = po2.getDriverNum().substring(0, 6)
									+ ThreeAutoNum.toThreeNum(Integer
											.parseInt(po2.getDriverNum()
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
