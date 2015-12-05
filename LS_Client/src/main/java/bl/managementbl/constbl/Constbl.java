package bl.managementbl.constbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.managementbl.managedata.ManageData;
import bl.managementbl.managedata.ManageVOPO;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import util.InputCheck;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.ConstNotFoundException;
import PO.ConstPO;
import VO.ManagementVO.AccountVO;
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
		// logbl = new Logbl();
		manageVOPO = ManageVOPO.getInstance();
	}

	public ResultMessage insert(ConstVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_MAKE);
		if (constDataService != null) {
			try {
				constDataService.insert(manageVOPO.voToPO(vo));
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

	public ResultMessage update(ConstVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_MAKE);
		if (constDataService != null) {
			ConstPO po = manageVOPO.voToPO(vo);
			try {
				constDataService.update(po);
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

	public ResultMessage delete(ConstVO VO) throws RemoteException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_MAKE);
		if (constDataService != null) {
			ConstPO po = manageVOPO.voToPO(VO);
			try {
				constDataService.delete(po);
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

	public ArrayList<ConstVO> show() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_MAKE);
		if (constDataService != null) {
			ArrayList<ConstPO> pos = constDataService.show();
			ArrayList<ConstVO> vos = new ArrayList<ConstVO>();
			ConstVO vo;
			for (ConstPO po : pos) {
				vo = manageVOPO.poToVO(po);
				vos.add(vo);
			}
			return vos;
		} else
			throw new RemoteException();
	}

	public ConstVO findByCities(String twoCities) throws FileNotFoundException,
			ClassNotFoundException, ConstNotFoundException, IOException {
		// TODO Auto-generated method stub
		manageVOPO.addLog(LogType.DECISION_MAKE);
		if (constDataService != null) {
			ConstPO findPO = constDataService.findByCities(twoCities);
			ConstVO findVO = manageVOPO.poToVO(findPO);
			return findVO;
		} else {
			throw new RemoteException();
		}
	}
	
}
