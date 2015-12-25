package bl.managementbl.constbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;


import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import util.enumData.City;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import util.enumData.ShipForm;
import Exception.ConstNotFoundException;
import PO.ConstPO;
import VO.ManagementVO.ConstVO;

public class Constbl {
	private ConstDataService constDataService;
	private ManageVOPO manageVOPO;

	public Constbl() {
		// TODO Auto-generated constructor stub
		super();
		try {
			ManageDataService manageDataService = ManageData.getInstance();
			constDataService = (ConstDataService) manageDataService
					.getConstData();
		} catch (RemoteException e) {
			System.out.println("远程获取constDataService失败!");
			e.printStackTrace();
		}
		manageVOPO = ManageVOPO.getInstance();
	}

	/**
	 * @param vo
	 * @return OVER_DATA IOFAILED SUCCESS FAILED
	 * @thr ows RemoteException
	 */
	public ResultMessage add(ConstVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_CONST);
		if (constDataService != null) {
			ResultMessage rmsg = null;
			try {
				ArrayList<ConstPO> pos = constDataService.show();
				if (pos != null) {
					for (Iterator<ConstPO> t = pos.iterator(); t.hasNext();) {
						if (t.next().getTwoCities().equals(vo.twoCities)) {
							return ResultMessage.OVERRIDE_DATA;
						}
					}
				}
				rmsg = constDataService.insert(manageVOPO.voToPO(vo));
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
			return rmsg;
		} else
			return ResultMessage.FAILED;
	}

	public ResultMessage update(ConstVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_CONST);
		if (constDataService != null) {
			ResultMessage rmsg = check(vo);
			if (check(vo) == ResultMessage.VALID) {
				ConstPO po = manageVOPO.voToPO(vo);
				try {
					rmsg = constDataService.update(po);
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
				return check(vo);
			}
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ResultMessage delete(ConstVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_CONST);
		if (constDataService != null) {
			ResultMessage rmsg = ResultMessage.WRONG_DATA;
			if (VO.twoCities.contains("-") && VO.twoCities.length() < 20) {
				ConstPO po = manageVOPO.voToPO(VO);
				try {
					rmsg = constDataService.delete(po);
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
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ArrayList<ConstVO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_CONST);
		if (constDataService != null) {
			ArrayList<ConstPO> pos = constDataService.show();
			if (pos != null) {
				ArrayList<ConstVO> vos = new ArrayList<ConstVO>();
				ConstVO vo;
				for (ConstPO po : pos) {
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

	public ConstVO findByCities(String twoCities) throws FileNotFoundException,
			ClassNotFoundException, ConstNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_CONST);
		if (constDataService != null) {
			ConstPO findPO = constDataService.findByCities(twoCities);
			ConstVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}

	public double computeFare(City c1, City c2, ShipForm shipForm, double weight)
			throws FileNotFoundException, ClassNotFoundException,
			ConstNotFoundException, IOException {
		String twoCities = "";
		double result = 0;
		if (c1.ordinal() < c2.ordinal()) {
			twoCities = c1.toString() + "-" + c2.toString();
		} else {
			twoCities = c2.toString() + "-" + c1.toString();
		}
		ConstVO v = findByCities(twoCities);
		double price=v.priceConst;
		double distance=v.distanceConst;
		result=price*shipForm.getRatio()*(weight/1000)*distance;
		assert(result!=0):("运费计算错误");
		return result;
	}

	/**
	 * check the constVO is valid or not
	 * 
	 * @param vo
	 * @return
	 */
	public static ResultMessage check(ConstVO vo) {
		if (vo.twoCities.contains("-") && vo.twoCities.length() < 20) {
			if (vo.distanceConst >= 30) {
				if (vo.priceConst > 0) {
					return ResultMessage.VALID;
				} else {
					return ResultMessage.WRONG_DATA;
				}
			} else {
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.WRONG_FORMAT;
		}
	}

}
