package dataservice.datafactoryservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.logindataservice.LoginDataService;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;

public class DataFactoryImpl implements DataFactory {
	private static final long serialVersionUID = 1L;

	private static DataFactory dataFactory;
	
	private static String url = "rmi://127.0.0.1:8888/";
	
	public DataFactoryImpl() throws RemoteException {
		super();
	}
	
	public static DataFactory getInstance() {
		if(dataFactory == null) {
			try {
				dataFactory = (DataFactory) Naming.lookup(url + "DataFactory");
			} catch (MalformedURLException | RemoteException
					| NotBoundException e) {
			}
		}
		return dataFactory;
	}

	@Override
	public AccountDataService getAccountData() throws RemoteException {
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

	@Override
	public LoginDataService getLoginData() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
