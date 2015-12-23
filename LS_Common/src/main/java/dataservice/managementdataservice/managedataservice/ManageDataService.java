package dataservice.managementdataservice.managedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.managementdataservice.accountdataservice.AccountDataService;
import dataservice.managementdataservice.accountdataservice.CourierDataService;
import dataservice.managementdataservice.bankaccountdataservice.BankAccountDataService;
import dataservice.managementdataservice.constdataservice.ConstDataService;
import dataservice.managementdataservice.institutiondataservice.InstitutionDataService;
import dataservice.managementdataservice.salarypolicydataservice.SalaryPolicyDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.DriverDataService;
import dataservice.managementdataservice.vehicleanddriverdataservice.VehicleDataService;

public interface ManageDataService extends Remote {
	/**
	 * 端口号9999
	 */
	public static final int port = 9999;

	public static final String regname = "ManageData";

	public AccountDataService getAccountData() throws RemoteException;
	
	public CourierDataService getCourierData() throws RemoteException;

	public BankAccountDataService getBankAccountData() throws RemoteException;

	public ConstDataService getConstData() throws RemoteException;

	public InstitutionDataService getInstitutionData() throws RemoteException;

	public SalaryPolicyDataService getSalaryPolicyData() throws RemoteException;

	public VehicleDataService getVehicleData() throws RemoteException;

	public DriverDataService getDriverData() throws RemoteException;

}
