package bl.managementbl.institutionbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import util.InputCheck;
import util.ThreeAutoNum;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.InstitutionNotFoundException;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import PO.DriverPO;
import PO.InstitutionPO;
import VO.ManagementVO.InstitutionVO;

public class Institutionbl {
	private InstitutionDataService institutionDataService;
	private ManageVOPO manageVOPO;

	public Institutionbl() {
		// TODO Auto-generated institutionructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			institutionDataService = (InstitutionDataService) manageDataService
					.getInstitutionData();
		} catch (RemoteException e) {
			System.out.println("远程获取institutionDataService失败!");
			e.printStackTrace();
		}
		manageVOPO = ManageVOPO.getInstance();
	}

	/**
	 * @param vo
	 * @return OVER_DATA IOFAILED SUCCESS FAILED
	 * @thr ows RemoteException
	 */
	public ResultMessage insert(InstitutionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.PERSONNEL_INSTITUTION_MANAGEMENT);
		if (institutionDataService != null) {
			try {
				ArrayList<InstitutionPO> pos = institutionDataService.show();
				if (vo.institutionNum.substring(3, 6).equals("000")) {
					InstitutionPO lastPO = null;
					String temp = vo.institutionNum.substring(0, 3);
					if (pos != null) {
						for (Iterator<InstitutionPO> t = pos.iterator(); t
								.hasNext();) {
							InstitutionPO p = t.next();
							if (p.getContactInfo().equals(vo.contactInfo)) {
								return ResultMessage.EXIST;
							}
							if (p.getInstitutionNum().substring(0, 3)
									.equals(temp)) {
								lastPO = p;
							}
						}
					}
					if (lastPO == null) {
						vo.institutionNum = vo.institutionNum.substring(0, 3)
								+ "001";
					} else {
						vo.institutionNum = vo.institutionNum.substring(0, 3)
								+ ThreeAutoNum.toThreeNum(Integer
										.parseInt(lastPO.getInstitutionNum()
												.substring(3, 6)) + 1);
					}
				}
				ResultMessage rmsg = institutionDataService.insert(manageVOPO
						.voToPO(vo));
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
			}
			return ResultMessage.SUCCESS;
		} else
			return ResultMessage.FAILED;
	}

	public ResultMessage update(InstitutionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.PERSONNEL_INSTITUTION_MANAGEMENT);
		if (institutionDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				InstitutionPO po = manageVOPO.voToPO(vo);
				try {
					ResultMessage rmsg = institutionDataService.update(po);
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
				return check(vo);
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage delete(InstitutionVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.PERSONNEL_INSTITUTION_MANAGEMENT);
		if (institutionDataService != null) {
			ResultMessage rmsg=null;
			InstitutionPO po = manageVOPO.voToPO(VO);
			try {
				 rmsg = institutionDataService.delete(po);
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
			return ResultMessage.WRONG_FORMAT;
		}
	}

	public ArrayList<InstitutionVO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.PERSONNEL_INSTITUTION_MANAGEMENT);
		if (institutionDataService != null) {
			ArrayList<InstitutionPO> pos = institutionDataService.show();
			if (pos != null) {
				ArrayList<InstitutionVO> vos = new ArrayList<InstitutionVO>();
				InstitutionVO vo;
				for (InstitutionPO po : pos) {
					vo = manageVOPO.poToVO(po);
					vos.add(vo);
				}
				return vos;
			} else {
				return null;
			}
		} else
			throw new RemoteException();
	}

	public InstitutionVO findByInstitutionNum(String institutionNum)
			throws FileNotFoundException, ClassNotFoundException,
			InstitutionNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.PERSONNEL_INSTITUTION_MANAGEMENT);
		if (institutionDataService != null) {
			InstitutionPO findPO = institutionDataService
					.findByInstitutionNum(institutionNum);
			InstitutionVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public InstitutionVO findByInstitutionName(String institutionName)
			throws FileNotFoundException, ClassNotFoundException,
			InstitutionNotFoundException, IOException, NameNotFoundException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.PERSONNEL_INSTITUTION_MANAGEMENT);
		if (institutionDataService != null) {
			InstitutionPO findPO = institutionDataService
					.findByinstitutionName(institutionName);
			InstitutionVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	/**
	 * check the institutionVO is valid or not
	 * 
	 * @param vo
	 * @return
	 */
	public static ResultMessage check(InstitutionVO vo) {
		if (InputCheck.checkInputNum(vo.institutionNum, 6) == ResultMessage.VALID) {
			if (InputCheck.checkInputName(vo.institutionName) == ResultMessage.VALID) {
				if (InputCheck.checkContactInfo(vo.contactInfo) == ResultMessage.VALID) {
					return ResultMessage.VALID;
				} else {
					return InputCheck.checkContactInfo(vo.contactInfo);
				}
			} else {
				return InputCheck.checkInputName(vo.institutionName);
			}
		} else {
			return InputCheck.checkInputNum(vo.institutionNum, 6);
		}
	}
}
