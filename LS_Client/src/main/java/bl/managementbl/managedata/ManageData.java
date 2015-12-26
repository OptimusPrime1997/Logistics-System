package bl.managementbl.managedata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import bl.loginbl.Loginbl;
import bl.loginbl.LoginblController;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import dataservice.managementdataservice.accountdataservice.CourierDataService;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;

public class ManageData extends UnicastRemoteObject implements
		ManageDataService {

	private static final long serialVersionUID = 1L;

	private static ManageDataService manageDataService;

	public static String address = Loginbl.getIP();

	public static int port = ManageDataService.port;

	public ManageData() throws RemoteException {
		super();
	}

	public static ManageDataService getInstance() {
		if (manageDataService == null) {
			try {
				String name = ManageDataService.regname;
				manageDataService = (ManageDataService) Naming.lookup("rmi://"
						+ address + ":" + port + "/" + name);
				System.out.println("远程连接成功");
			} catch (MalformedURLException | RemoteException
					| NotBoundException | ClassCastException e) {
				e.printStackTrace();
				System.out.println("远程连接错误");
			}
		}
		return manageDataService;
	}

	@Override
	public AccountDataService getAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourierDataService getCourierData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstDataService getConstData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InstitutionDataService getInstitutionData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryPolicyDataService getSalaryPolicyData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDataService getDriverData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
