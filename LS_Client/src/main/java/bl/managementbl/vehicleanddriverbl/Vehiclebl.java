package bl.managementbl.vehicleanddriverbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;
import util.InputCheck;
import util.ThreeAutoNum;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import PO.InstitutionPO;
import PO.VehiclePO;
import VO.ManagementVO.VehicleVO;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;

public class Vehiclebl {
	private VehicleDataService vehicleDataService;
	private ManageVOPO manageVOPO;

	public Vehiclebl() {
		// TODO Auto-generated constructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			vehicleDataService = (VehicleDataService) manageDataService
					.getVehicleData();
		} catch (RemoteException e) {
			System.out.println("远程获取vehicleDataService失败!");
			e.printStackTrace();
		}
		// logbl = new Logbl();
		manageVOPO = ManageVOPO.getInstance();
	}

	public ResultMessage insertVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.CAR_MANAGEMENT);
		if (vehicleDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				try {
					ArrayList<VehiclePO> pos = vehicleDataService.showVehicle();
					if (vo.vehicleNum.substring(6, 9).equals("000")) {
						VehiclePO lastPO = null;
						String temp = vo.vehicleNum.substring(0, 6);
						if (pos != null) {
							for (Iterator<VehiclePO> t = pos.iterator(); t
									.hasNext();) {
								VehiclePO p = t.next();
								if (p.getLicenseNum().equals(vo.licenseNum)) {
									return ResultMessage.EXIST;
								}
								if (p.getVehicleNum().substring(0, 6)
										.equals(temp)) {
									lastPO = p;
								}
							}
						}
						if (lastPO == null) {
							vo.vehicleNum = vo.vehicleNum.substring(0, 6)
									+ "001";
						} else {
							vo.vehicleNum = vo.vehicleNum.substring(0, 6)
									+ ThreeAutoNum.toThreeNum(Integer
											.parseInt(lastPO.getVehicleNum()
													.substring(6, 9)) + 1);
						}
					}
					ResultMessage rmsg = vehicleDataService
							.insertVehicle(manageVOPO.voToPO(vo));
					ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
					return ResultMessage.SUCCESS;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("存储文件出错");
					return ResultMessage.IOFAILED;
				} 
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("系统程序错误");
					return ResultMessage.FAILED;
				}
			} else {
				System.out.println("车辆"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage updateVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.CAR_MANAGEMENT);
		if (vehicleDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				VehiclePO po = manageVOPO.voToPO(vo);
				try {
					ResultMessage rmsg = vehicleDataService.updateVehicle(po);
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
				System.out.println("车辆"
						+ ResultMessage.toFriendlyString(check(vo)));
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage deleteVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.CAR_MANAGEMENT);
		if (vehicleDataService != null) {
			if (InputCheck.checkInputNum(vo.vehicleNum, 9) == ResultMessage.VALID) {
				VehiclePO po = manageVOPO.voToPO(vo);
				try {
					ResultMessage rmsg = vehicleDataService.deleteVehicle(po);
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
				System.out.println("车辆"
						+ InputCheck.checkInputNum(vo.vehicleNum, 9));
				return ResultMessage.WRONG_DATA;
			}
		} else
			return ResultMessage.FAILED;
	}

	public ArrayList<VehicleVO> showVehicle() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.CAR_MANAGEMENT);
		if (vehicleDataService != null) {
			ArrayList<VehiclePO> pos = vehicleDataService.showVehicle();
			ArrayList<VehicleVO> vos = new ArrayList<VehicleVO>();
			VehicleVO vo;
			for (VehiclePO po : pos) {
				vo = manageVOPO.poToVO(po);
				vos.add(vo);
			}
			return vos;
		} else
			throw new RemoteException();
	}

	public VehicleVO findByVehicleNum(String vehicleNum)
			throws FileNotFoundException, ClassNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.CAR_MANAGEMENT);
		if (vehicleDataService != null) {
			VehiclePO findPO = vehicleDataService.findByVehicleNum(vehicleNum);
			VehicleVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public ResultMessage check(VehicleVO vo) {
		if (InputCheck.checkInputNum(vo.vehicleNum, 9) == ResultMessage.VALID
				&& InputCheck.checkInputDate(vo.startTime) == ResultMessage.VALID
				&& vo.licenseNum.length() == 7) {
			return ResultMessage.VALID;
		} else {
			return ResultMessage.WRONG_DATA;
		}
	}
}
