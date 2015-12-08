package blservice.managementblservice.institutionblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import Exception.InstitutionNotFoundException;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ManagementVO.InstitutionVO;

public interface InstitutionBLService {
	public ResultMessage insert(InstitutionVO vo) throws RemoteException;

	public ResultMessage update(InstitutionVO vo) throws RemoteException;

	public ResultMessage delete(InstitutionVO vo) throws RemoteException;

	public ArrayList<InstitutionVO> show() throws RemoteException,
			ClassNotFoundException, IOException;

	public InstitutionVO findByInstitutionNum(String institutionNum)
			throws RemoteException, FileNotFoundException,
			ClassNotFoundException, InstitutionNotFoundException, IOException,
			NumNotFoundException;

	public InstitutionVO findByInstitutionName(String institutionName)
			throws RemoteException, FileNotFoundException,
			ClassNotFoundException, InstitutionNotFoundException, IOException,
			NameNotFoundException;

}
