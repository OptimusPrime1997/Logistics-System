package dataservice.datafactoryservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataimpl.management.accountdata.AccountData;
import dataimpl.management.bankaccountdata.BankAccountData;
import dataimpl.management.constdata.ConstData;
import dataimpl.management.institutiondata.InstitutionData;
import dataimpl.management.salarypolicydata.SalaryPolicyData;
import dataimpl.management.vehicleanddriverdata.VehicleData;
import dataservice.logindataservice.LoginDataService;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;

public class DataFactoryImpl  extends UnicastRemoteObject implements DataFactory {
	
	private static final long serialVersionUID = 1L;

	private static DataFactory dataFactory;
	
	public static String address = "127.0.0.1";

	public static String port = "8888";
	
	public DataFactoryImpl() throws RemoteException {
		super();
	}
	
	public static DataFactory getInstance() {
		try {
			dataFactory = (DataFactory) Naming.lookup("rmi://" + address + ":" + port + "/DataFactory");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
		}
		return dataFactory;
	}
	

	@Override
	public AccountDataService getAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return new AccountData();
	}

	@Override
	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		return new BankAccountData();
	}

	@Override
	public ConstDataService getConstData() throws RemoteException {
		// TODO Auto-generated method stub
		return new ConstData();
	}

	@Override
	public InstitutionDataService getInstitutionData() throws RemoteException {
		// TODO Auto-generated method stub
		return new InstitutionData();
	}

	@Override
	public SalaryPolicyDataService getSalaryPolicyData() throws RemoteException {
		// TODO Auto-generated method stub
		return new SalaryPolicyData();
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		// TODO Auto-generated method stub
		return new VehicleData();
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
