package PO;

import java.util.ArrayList;

public class PayRepPO extends ReceiptPO {
	private String BankAccountNum;
	private String PayPersonNum;
	private ArrayList<LittleThing> littleThings;
	private ArrayList<Salary> Salarys; 
	private ArrayList<TransferPay> TransferPays;
	private ArrayList<Rent> rents;

	public class Salary {
		public String getterName;
		public String getterNum;
		public String date;
		public double money;
		
		public Salary(String getterName, String getterNum, String date, double money) {
			super();
			this.getterName = getterName;
			this.getterNum = getterNum;
			this.date = date;
			this.money = money;
		}

		public String getGetterName() {
			return getterName;
		}

		public String getGetterNum() {
			return getterNum;
		}

		public String getDate() {
			return date;
		}

		public double getMoney() {
			return money;
		}
		
	}

	class TransferPay {
		public String transferRepNum;
		public String date;
		public double money;
		
		public TransferPay(String transferRepNum, String date, double money) {
			super();
			this.transferRepNum = transferRepNum;
			this.date = date;
			this.money = money;
		}

		public String getTransferRepNum() {
			return transferRepNum;
		}

		public String getDate() {
			return date;
		}

		public double getMoney() {
			return money;
		}
		
	}

	class Rent {
		public String getterName;
		public String phoneNum;
		public double money;
		public String date;
		
		public Rent(String getterName, String phoneNum, double money, String date) {
			super();
			this.getterName = getterName;
			this.phoneNum = phoneNum;
			this.money = money;
			this.date = date;
		}

		public String getGetterName() {
			return getterName;
		}

		public String getPhoneNum() {
			return phoneNum;
		}

		public double getMoney() {
			return money;
		}

		public String getDate() {
			return date;
		}
		
	}

	class LittleThing {
		public String date;
		public String reason;
		public double money;
		
		public LittleThing(String date, String reason, double money) {
			super();
			this.date = date;
			this.reason = reason;
			this.money = money;
		}

		public String getDate() {
			return date;
		}

		public String getReason() {
			return reason;
		}

		public double getMoney() {
			return money;
		}
		
	}

	public PayRepPO(String num, String date, String bankAccountNum, String payPersonNum,
			ArrayList<LittleThing> littleThings, ArrayList<Salary> salarys, ArrayList<TransferPay> transferPays,
			ArrayList<Rent> rents) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		this.littleThings = littleThings;
		Salarys = salarys;
		TransferPays = transferPays;
		this.rents = rents;
	}

	public String getBankAccountNum() {
		return BankAccountNum;
	}

	public String getPayPersonNum() {
		return PayPersonNum;
	}

	public ArrayList<LittleThing> getLittleThings() {
		return littleThings;
	}

	public ArrayList<Salary> getSalarys() {
		return Salarys;
	}

	public ArrayList<TransferPay> getTransferPays() {
		return TransferPays;
	}

	public ArrayList<Rent> getRents() {
		return rents;
	}
	
}
