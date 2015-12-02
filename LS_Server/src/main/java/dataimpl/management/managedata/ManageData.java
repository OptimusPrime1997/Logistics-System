package dataimpl.management.managedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataimpl.management.accountdata.AccountData;
import dataimpl.management.bankaccountdata.BankAccountData;
import dataimpl.management.constdata.ConstData;
import dataimpl.management.institutiondata.InstitutionData;
import dataimpl.management.salarypolicydata.SalaryPolicyData;
import dataimpl.management.vehicleanddriverdata.DriverData;
import dataimpl.management.vehicleanddriverdata.VehicleData;
import dataservice.managementdataservice.accountdataservice.AccountDataService;
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

	private static ManageData manageData;
	private static AccountData accountData;
	private static BankAccountData bankAccountData;
	private static ConstData constData;
	private static InstitutionData institutionData;
	private static SalaryPolicyData salaryPolicyData;
	private static VehicleData vehicleData;
	private static DriverData driverData;

	public ManageData() throws RemoteException {
		super();
	}

	public static ManageData getInstance() {
		if (manageData == null) {
			try {
				manageData = new ManageData();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return manageData;
	}

	@Override
	public AccountDataService getAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		if (accountData == null)
			accountData = new AccountData();
		return accountData;
	}

	@Override
	public BankAccountDataService getBankAccountData() throws RemoteException {
		// TODO Auto-generated method stub
		if (bankAccountData == null)
			bankAccountData = new BankAccountData();
		return bankAccountData;
	}

	@Override
	public ConstDataService getConstData() throws RemoteException {
		// TODO Auto-generated method stub
		if (constData == null)
			constData = new ConstData();
		return constData;
	}

	@Override
	public InstitutionDataService getInstitutionData() throws RemoteException {
		// TODO Auto-generated method stub
		if (institutionData == null)
			institutionData = new InstitutionData();
		return institutionData;
	}

	@Override
	public SalaryPolicyDataService getSalaryPolicyData() throws RemoteException {
		// TODO Auto-generated method stub
		if (salaryPolicyData == null)
			salaryPolicyData = new SalaryPolicyData();
		return salaryPolicyData;
	}

	@Override
	public VehicleDataService getVehicleData() throws RemoteException {
		// TODO Auto-generated method stub
		if (vehicleData == null)
			vehicleData = new VehicleData();
		return vehicleData;
	}

	@Override
	public DriverDataService getDriverData() throws RemoteException {
		// TODO Auto-generated method stub
		if (driverData == null)
			driverData = new DriverData();
		return driverData;
	}
}