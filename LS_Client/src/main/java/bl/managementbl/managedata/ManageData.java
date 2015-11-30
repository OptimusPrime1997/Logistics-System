package bl.managementbl.managedata;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import dataservice.managementdataservice.managedataservice.ManageDataService;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;

public class ManageData  extends UnicastRemoteObject implements ManageDataService {
	
	private static final long serialVersionUID = 1L;

private static ManageData manageData;
	
	public static String address = "127.0.0.1";

	public static String port = "8888";
	
	public ManageData() throws RemoteException {
		super();
	}
	
	public static ManageData getInstance() {
		try {
			manageData = (ManageData) Naming.lookup("rmi://" + address + ":" + port + "/DataFactory");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return manageData;
	}
	

	@Override
	public AccountDataService getAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getAccountData();
	}

	@Override
	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getBankAccountData();
	}

	@Override
	public ConstDataService getConstData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getConstData();
	}

	@Override
	public InstitutionDataService getInstitutionData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getInstitutionData();
	}

	@Override
	public SalaryPolicyDataService getSalaryPolicyData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getSalaryPolicyData();
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getVehicleData();
	}

	@Override
	public DriverDataService getDriverData() throws RemoteException {
		// TODO Auto-generated method stub
		return manageData.getDriverData();
	}

}
