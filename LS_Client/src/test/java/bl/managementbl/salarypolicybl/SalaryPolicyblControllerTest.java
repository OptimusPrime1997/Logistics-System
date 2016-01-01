//package bl.managementbl.salarypolicybl;
//
//import static org.junit.Assert.*;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.rmi.RemoteException;
//
//import org.junit.AfterClass;
//import org.junit.Test;
//
//import util.enumData.Authority;
//import util.enumData.ResultMessage;
//import util.enumData.SalaryPolicy;
//import Exception.SalaryPolicyNotFoundException;
//import Exception.NumNotFoundException;
//import VO.ManagementVO.SalaryPolicyVO;
//
//public class SalaryPolicyblControllerTest {
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		SalaryPolicyblController salaryPolicyblController = new SalaryPolicyblController();
//		SalaryPolicyVO vo = null;
//		SalaryPolicyVO vo1 = null;
//		try {
//			ResultMessage[] rmsgs = new ResultMessage[9];
//			rmsgs[0] = salaryPolicyblController.insert(new SalaryPolicyVO(
//					Authority.MANAGER, SalaryPolicy.BASE_SALARY,9000));
//			rmsgs[1] = salaryPolicyblController.insert(new SalaryPolicyVO(
//					Authority.FINANCIALSTAFF_C, SalaryPolicy.BASE_SALARY, 8800));
//			rmsgs[2] = salaryPolicyblController
//					.insert(new SalaryPolicyVO(Authority.BUSSINESSOFFICER,
//							SalaryPolicy.BASE_SALARY, 8500));
//			rmsgs[3] = salaryPolicyblController.insert(new SalaryPolicyVO(
//					Authority.TRANSFERCTROFFICER, SalaryPolicy.SHARE_SALARY, 8700));
//			rmsgs[4] = salaryPolicyblController.insert(new SalaryPolicyVO(
//					Authority.WAREHOUSEMAN, SalaryPolicy.BASE_SALARY, 8600));
//			
//			rmsgs[5] = salaryPolicyblController
//					.insert(new SalaryPolicyVO(Authority.COURIER,
//							SalaryPolicy.SHARE_SALARY, 0.2));
//			rmsgs[6] = salaryPolicyblController.insert(new SalaryPolicyVO(
//					Authority.DRIVER, SalaryPolicy.FREQUENCY_SALARY, 50));
//			
//			rmsgs[7] = salaryPolicyblController.insert(new SalaryPolicyVO(
//					Authority.ADMINISTRATOR, SalaryPolicy.BASE_SALARY, 8400));
//			rmsgs[8] = salaryPolicyblController
//					.insert(new SalaryPolicyVO(Authority.FINANCIALSTAFF_V,
//							SalaryPolicy.BASE_SALARY, 8900));
//			for (int i = 0; i < 3; i++) {
//				System.out.println(rmsgs[i].toString());
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("远程连接错误");
//		}
//		try {
//			vo = salaryPolicyblController.findByAuthority(Authority.COURIER);
//			System.out.println(vo.salaryPolicy);
//			assertEquals(SalaryPolicy.SHARE_SALARY, vo.salaryPolicy);
//			// salaryPolicybl.delete(vo);
//			vo1 = salaryPolicyblController
//					.findByAuthority(Authority.BUSSINESSOFFICER);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SalaryPolicyNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NumNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (vo1 != null) {
//			assertEquals(8500, vo1.value, 0.1);
//		} else {
//			System.out.println("vo is null");
//		}
//
//	}
//
//}
