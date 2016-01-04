package bl.managementbl.accountbl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import util.enumData.Sex;
import Exception.NumNotFoundException;
import VO.ManagementVO.AccountVO;

public class AccountblTest {

	@Test
	public void test() {
		ResultMessage rmsg = null;
		ArrayList<ResultMessage> rmsgs = new ArrayList<ResultMessage>();
		Accountbl accountbl = new Accountbl();
		AccountVO vo = null;
		AccountVO vo1 = null;
		try {
			rmsg = accountbl.add(new AccountVO("02500101001", "王二", "1111",
					Sex.Sex_MALE, Authority.MANAGER, "12345672501", "025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500102001", "周季", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345672502",
					"025002"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02500203001", "王石", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345672503",
					"025002"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500303001", "王一", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345672510",
					"025003"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02500104001", "万科", "1111",
					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345672504",
					"025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500105001", "雷八", "1111",
					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345672505",
					"025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl
					.add(new AccountVO("02500206001", "周五", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345672506",
							"025002"));
			rmsg = accountbl
					.add(new AccountVO("02500306001", "赵云", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345672511",
							"025003"));
			rmsg = accountbl.add(new AccountVO("02500108001", "张天", "1111",
					Sex.Sex_FAMALE, Authority.ADMINISTRATOR, "12345672511",
					"025001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02500109001", "王东", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_V, "12345672509",
					"025001"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02100101001", "赵一", "1111",
					Sex.Sex_MALE, Authority.MANAGER, "12345672101", "021001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02100102101", "赵二", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345672102",
					"021002"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02100203001", "赵三", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345672103",
					"021002"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02100303001", "赵四", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345672110",
					"021003"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02100104001", "赵五", "1111",
					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345672104",
					"021001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02100105001", "赵六", "1111",
					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345672105",
					"021001"));
			rmsgs.add(rmsg);
			rmsg = accountbl
					.add(new AccountVO("02100206001", "赵七", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345672106",
							"021002"));
			rmsg = accountbl
					.add(new AccountVO("02100306001", "赵八", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345672111",
							"021003"));
			rmsg = accountbl.add(new AccountVO("02100108001", "赵九", "1111",
					Sex.Sex_FAMALE, Authority.ADMINISTRATOR, "12345672111",
					"021001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02100109001", "赵十", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_V, "12345672109",
					"021001"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02000101001", "方一", "1111",
					Sex.Sex_MALE, Authority.MANAGER, "12345672001", "020001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02000102001", "方二", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345672002",
					"020002"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02000203001", "方三", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345672003",
					"020002"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02000303001", "方四", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345672010",
					"020003"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("02000104001", "方五", "1111",
					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345672004",
					"020001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02000105001", "方六", "1111",
					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345672005",
					"020001"));
			rmsgs.add(rmsg);
			rmsg = accountbl
					.add(new AccountVO("02000206001", "方七", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345672006",
							"020002"));
			rmsg = accountbl
					.add(new AccountVO("02000306001", "方八", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345672011",
							"020003"));
			rmsg = accountbl.add(new AccountVO("02000108001", "方九", "1111",
					Sex.Sex_FAMALE, Authority.ADMINISTRATOR, "12345672011",
					"020001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("02000109001", "方十", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_V, "12345672009",
					"020001"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("01000101001", "胡一", "1111",
					Sex.Sex_MALE, Authority.MANAGER, "12345671001", "010001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("01000101001", "胡二", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_C, "12345671002",
					"010002"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("01000103001", "胡三", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345671003",
					"010002"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("01000303001", "胡四", "1111",
					Sex.Sex_MALE, Authority.BUSSINESSOFFICER, "12345671010",
					"010003"));
			rmsgs.add(rmsg);

			rmsg = accountbl.add(new AccountVO("01000104001", "胡五", "1111",
					Sex.Sex_MALE, Authority.TRANSFERCTROFFICER, "12345671004",
					"010001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("01000105001", "胡六", "1111",
					Sex.Sex_MALE, Authority.WAREHOUSEMAN, "12345671005",
					"010001"));
			rmsgs.add(rmsg);
			rmsg = accountbl
					.add(new AccountVO("01000106001", "胡七", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345671006",
							"010002"));
			rmsg = accountbl
					.add(new AccountVO("01000306001", "胡八", "1111",
							Sex.Sex_FAMALE, Authority.COURIER, "12345671011",
							"010003"));
			rmsg = accountbl.add(new AccountVO("01000108001", "胡九", "1111",
					Sex.Sex_FAMALE, Authority.ADMINISTRATOR, "12345671011",
					"010001"));
			rmsgs.add(rmsg);
			rmsg = accountbl.add(new AccountVO("01000109001", "胡十", "1111",
					Sex.Sex_MALE, Authority.FINANCIALSTAFF_V, "12345671009",
					"010001"));
			rmsgs.add(rmsg);
			for (int i = 0; i < rmsgs.size(); i++) {
				System.out.println(rmsgs.get(i));
			}
			// vo = accountbl.findByAccountNum("02500101001");
			// System.out.println(vo.accountName);
			// assertEquals("王二", vo.accountName);
			// assertEquals("1111", vo.password);
			// // accountbl.delete(vo);
			vo1 = accountbl.findByAccountNum("02500102001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("远程连接错误");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系统程序错误！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if (vo1 != null) {
		// assertEquals("2222", vo1.password);
		// } else
		// System.out.println("vo1 is null");

	}

}
