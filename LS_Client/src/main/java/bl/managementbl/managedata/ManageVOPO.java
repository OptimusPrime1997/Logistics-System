package bl.managementbl.managedata;

import util.enumData.SalaryPolicy;
import PO.AccountPO;
import PO.BankAccountPO;
import PO.ConstPO;
import PO.DriverPO;
import PO.InstitutionPO;
import PO.SalaryPolicyPO;
import PO.VehiclePO;
import PO.ReceiptPO.SalaryPO;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.BankAccountVO;
import VO.ManagementVO.ConstVO;
import VO.ManagementVO.DriverVO;
import VO.ManagementVO.InstitutionVO;
import VO.ManagementVO.SalaryPolicyVO;
import VO.ManagementVO.VehicleVO;

public class ManageVOPO {
	public AccountPO voToPO(AccountVO vo) {
		return new AccountPO(vo.accountNum, vo.accountName, vo.password,
				vo.sex, vo.authority, vo.phoneNum, vo.institutionNum);
	}

	public BankAccountPO voToPO(BankAccountVO vo) {
		return new BankAccountPO(vo.bankAccountNum, vo.bankAccountName,
				vo.balance);
	}

	public ConstPO voToPO(ConstVO vo) {
		return new ConstPO(vo.twoCities, vo.priceConst, vo.distanceConst);
	}

	public InstitutionPO voToPO(InstitutionVO vo) {
		return new InstitutionPO(vo.institutionNum, vo.institutionName,
				vo.address, vo.contactInfo, vo.manning);
	}

	public SalaryPolicyPO voToPO(SalaryPolicyVO vo) {
		return new SalaryPolicyPO(vo.authority, vo.salaryPolicy,
				vo.salaryAmount);
	}

	public DriverPO voToPO(DriverVO vo) {
		return new DriverPO(vo.driverNum, vo.name, vo.birthDate, vo.id,
				vo.phoneNum, vo.sex, vo.licensedTime);
	}

	public VehiclePO voToPO(VehicleVO vo) {
		return new VehiclePO(vo.vehicleNum, vo.licenseNum, vo.startTime);
	}

	public AccountVO poToVO(AccountPO po) {
		return new AccountVO(po.getAccountNum(), po.getAccountName(),
				po.getPassword(), po.getSex(), po.getAuthority(),
				po.getPhoneNum(), po.getInstitutionNum());
	}

	public BankAccountVO poToVO(BankAccountPO po) {
		return new BankAccountVO(po.getBankAccountNum(),
				po.getBankAccountName(), po.getBalance());
	}

	public ConstVO poToVO(ConstPO po) {
		return new ConstVO(po.getTwoCities(), po.getPriceConst(),
				po.getDistanceConst());
	}

	public InstitutionVO poToVO(InstitutionPO po) {
		return new InstitutionVO(po.getInstitutionNum(),
				po.getInstitutionName(), po.getAddress(), po.getContactInfo(),
				po.getManning());
	}

	public SalaryPolicyVO poToVO(SalaryPolicyPO po) {
		return new SalaryPolicyVO(po.getAuthority(), po.getSalaryPolicy(),
				po.getSalaryAmount());
	}

	public DriverVO poToVO(DriverPO po) {
		return new DriverVO(po.getDriverNum(), po.getName(), po.getBirthDate(),
				po.getId(), po.getPhoneNum(), po.getSex(), po.getLicensedTime());
	}

	public VehicleVO poToVO(VehiclePO po) {
		return new VehicleVO(po.getVehicleNum(), po.getLicenseNum(),
				po.getStartTime());
	}
}
