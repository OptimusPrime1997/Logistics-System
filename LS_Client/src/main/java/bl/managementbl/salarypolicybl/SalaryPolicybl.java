package bl.managementbl.salarypolicybl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import util.InputCheck;
import util.enumData.Authority;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.SalaryPolicyNotFoundException;
import Exception.NumNotFoundException;
import PO.SalaryPolicyPO;
import VO.ManagementVO.SalaryPolicyVO;
import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;

public class SalaryPolicybl {
	private SalaryPolicyDataService salaryPolicyDataService;
	private ManageVOPO manageVOPO;

	public SalaryPolicybl() {
		// TODO Auto-generated salaryPolicyructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			salaryPolicyDataService = (SalaryPolicyDataService) manageDataService
					.getSalaryPolicyData();
		} catch (RemoteException e) {
			System.out.println("远程获取salaryPolicyDataService失败!");
			e.printStackTrace();
		}
		manageVOPO = ManageVOPO.getInstance();
	}

	/**
	 * @param vo
	 * @return OVER_DATA IOFAILED SUCCESS FAILED
	 * @thr ows RemoteException
	 */
	public ResultMessage insert(SalaryPolicyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_SALARYPOLICY);
		if (salaryPolicyDataService != null) {
			try {
				ArrayList<SalaryPolicyPO> pos = salaryPolicyDataService.show();
				if (pos != null) {
					for (Iterator<SalaryPolicyPO> t = pos.iterator(); t
							.hasNext();) {
						if (t.next().getAuthority() == (vo.authority)) {
							return ResultMessage.EXIST;
						}
					}
				}
				if(check(vo)==ResultMessage.VALID){
				ResultMessage rmsg = salaryPolicyDataService.insert(manageVOPO
						.voToPO(vo));
				ResultMessage.postCheck(ResultMessage.SUCCESS, rmsg);
				}else{
					System.out.println(check(vo).toString());
				}
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

	public ResultMessage update(SalaryPolicyVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_SALARYPOLICY);
		if (salaryPolicyDataService != null) {
			if (check(vo) == ResultMessage.VALID) {
				SalaryPolicyPO po = manageVOPO.voToPO(vo);
				try {
					ResultMessage rmsg = salaryPolicyDataService.update(po);
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

	public ResultMessage delete(SalaryPolicyVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_SALARYPOLICY);
		if (salaryPolicyDataService != null) {
			SalaryPolicyPO po = manageVOPO.voToPO(VO);
			try {
				ResultMessage rmsg = salaryPolicyDataService.delete(po);
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
			return ResultMessage.REMOTE_FAILED;
		}

	}

	public ArrayList<SalaryPolicyVO> show() throws ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_SALARYPOLICY);
		if (salaryPolicyDataService != null) {
			ArrayList<SalaryPolicyPO> pos = salaryPolicyDataService.show();
			if (pos != null) {
				ArrayList<SalaryPolicyVO> vos = new ArrayList<SalaryPolicyVO>();
				SalaryPolicyVO vo;
				for (SalaryPolicyPO po : pos) {
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

	public SalaryPolicyVO findByAuthority(Authority authority)
			throws FileNotFoundException, ClassNotFoundException,
			SalaryPolicyNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_SALARYPOLICY);
		if (salaryPolicyDataService != null) {
			SalaryPolicyPO findPO = salaryPolicyDataService
					.findByAuthority(authority);
			SalaryPolicyVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	/**
	 * check the salaryPolicyVO is valid or not authority and salarypolicy is
	 * null or not
	 * 
	 * @param vo
	 * @return
	 */
	public static ResultMessage check(SalaryPolicyVO vo) {
		if (vo.value >= 0.0) {
			if (vo.salaryPolicy != null) {
				if (vo.authority != null) {
					return ResultMessage.VALID;
				} else {
					return ResultMessage.NULL_AUTHORITY;
				}
			} else {
				return ResultMessage.NULL_SALARYPOLICY;
			}
		} else {
			return ResultMessage.INPUTNUM_MUST_BE_POSITIVE;
		}
	}

}
