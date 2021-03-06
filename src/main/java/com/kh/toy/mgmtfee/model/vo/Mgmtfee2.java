package com.kh.toy.mgmtfee.model.vo;

import java.sql.Date;

public class Mgmtfee2 {
	private String mgmtfeeIdx;
	private String apartmentIdx; //아파트번호
	private String generationIdx; //세대관리번호
	private String gnrlMgmtFee; //일반관리비
	private String cleanFee; // 청소비
	private String elvtrMnfee; //승강기 유지비
	private String genElctr; //세대전기료
	private String comonElctr; //공동전기료
	private String genWater; //세대수도료
	private String sewer; //하수도료
	private String expenses; //경비비
	private String genReduction; //세대감면액
	private String periodPayment; //납기내 금액
	private Date dueDate; //납기일
	private Date mgmtStartDate; // 관리시작일
	private Date mgmtEndDate; // 관리종료일
	private Date mgmtWriteDate; //관리비 작성일
	private int isPayment; //결제여부
	private int isOverdue; //연체여부

	
	public Mgmtfee2() {
		super();
	}

	private Mgmtfee2(MgmtBuilder builder) {
		this.mgmtfeeIdx = builder.mgmtfeeIdx;
		this.apartmentIdx = builder.apartmentIdx;
		this.generationIdx = builder.generationIdx;
		this.gnrlMgmtFee = builder.gnrlMgmtFee;
		this.cleanFee = builder.cleanFee;
		this.elvtrMnfee = builder.elvtrMnfee;
		this.genElctr = builder.genElctr;
		this.comonElctr = builder.comonElctr;
		this.genWater = builder.genWater;
		this.sewer = builder.sewer;
		this.expenses = builder.expenses;
		this.genReduction = builder.genReduction;
		this.periodPayment = builder.periodPayment;
		this.dueDate = builder.dueDate;
		this.mgmtStartDate = builder.mgmtStartDate;
		this.mgmtEndDate = builder.mgmtEndDate;
		this.mgmtStartDate = builder.mgmtStartDate;
		this.mgmtWriteDate = builder.mgmtWriteDate;
		this.isPayment = builder.isPayment;
		this.isOverdue = builder.isOverdue;

	}
	
	public static MgmtBuilder builder() {
		return new MgmtBuilder();
	}
	
	public static class MgmtBuilder{
		// 엑셀로 입력받을 값
		private String mgmtfeeIdx;
		private String apartmentIdx;
		private String generationIdx; //세대관리번호
		private String gnrlMgmtFee; //일반관리비
		private String cleanFee; // 청소비
		private String elvtrMnfee; //승강기 유지비
		private String genElctr; //세대전기료
		private String comonElctr; //공동전기료
		private String genWater; //세대수도료
		private String sewer; //하수도료
		private String expenses; //경비비
		private String genReduction; //세대감면액
		private String periodPayment; //납기내 금액
		private Date dueDate; //납기일
		private Date mgmtStartDate; // 관리시작일
		private Date mgmtEndDate; // 관리종료일
		private Date mgmtWriteDate; //관리비 작성일
		private int isPayment; //결제여부
		private int isOverdue; //연체여부

		
		public MgmtBuilder isPayment(int val) {
			this.isPayment = val;
			return this;
		}
		
		public MgmtBuilder isOverdue(int val) {
			this.isOverdue = val;
			return this;
		}
		
		public MgmtBuilder mgmtfeeIdx(String val) {
			this.mgmtfeeIdx = val;
			return this;
		}
		
		public MgmtBuilder apartmentIdx(String val) {
			this.apartmentIdx = val;
			return this;
		}
		
		public MgmtBuilder generationIdx(String val) {
			this.generationIdx = val;
			return this;
		}
		
		public MgmtBuilder gnrlMgmtFee(String val) {
			this.gnrlMgmtFee = val;
			return this;
		}
		
		public MgmtBuilder cleanFee(String val) {
			this.cleanFee = val;
			return this;
		}
		
		public MgmtBuilder elvtrMnfee(String val) {
			this.elvtrMnfee = val;
			return this;
		}
		
		public MgmtBuilder genElctr(String val) {
			this.genElctr = val;
			return this;
		}
		
		public MgmtBuilder comonElctr(String val) {
			this.comonElctr = val;
			return this;
		}
		
		public MgmtBuilder genWater(String val) {
			this.genWater = val;
			return this;
		}
		
		public MgmtBuilder sewer(String val) {
			this.sewer = val;
			return this;
		}
		
		public MgmtBuilder expenses(String val) {
			this.expenses = val;
			return this;
		}
		
		public MgmtBuilder genReduction(String val) {
			this.genReduction = val;
			return this;
		}
		
		public MgmtBuilder periodPayment(String val) {
			this.periodPayment = val;
			return this;
		}

		public MgmtBuilder dueDate(Date val) {
			this.dueDate = val;
			return this;
		}

		public MgmtBuilder mgmtStartDate(Date val) {
			this.mgmtStartDate = val;
			return this;
		}
		
		public MgmtBuilder mgmtEndDate(Date val) {
			this.mgmtEndDate = val;
			return this;
		}
		
		public MgmtBuilder mgmtWriteDate(Date val) {
			this.mgmtWriteDate = val;
			return this;
		}
		
		public Mgmtfee2 build() {
			return new Mgmtfee2(this);
		}
	}
	

	public String getApartmentIdx() {
		return apartmentIdx;
	}

	public String getPeriodPayment() {
		return periodPayment;
	}
	public String getMgmtfeeIdx() {
		return mgmtfeeIdx;
	}
	public String getGenerationIdx() {
		return generationIdx;
	}
	public String getGnrlMgmtFee() {
		return gnrlMgmtFee;
	}
	public String getCleanFee() {
		return cleanFee;
	}
	public String getElvtrMnfee() {
		return elvtrMnfee;
	}
	public String getGenElctr() {
		return genElctr;
	}
	public String getComonElctr() {
		return comonElctr;
	}
	public String getGenWater() {
		return genWater;
	}
	public String getSewer() {
		return sewer;
	}
	public String getExpenses() {
		return expenses;
	}
	public String getGenReduction() {
		return genReduction;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public Date getMgmtStartDate() {
		return mgmtStartDate;
	}
	public Date getMgmtEndDate() {
		return mgmtEndDate;
	}
	public Date getMgmtWriteDate() {
		return mgmtWriteDate;
	}
	public int getIsPayment() {
		return isPayment;
	}
	public int getIsOverdue() {
		return isOverdue;
	}

	@Override
	public String toString() {
		return "Mgmtfee [mgmtfeeIdx=" + mgmtfeeIdx + ", apartmentIdx=" + apartmentIdx + ", generationIdx="
				+ generationIdx + ", gnrlMgmtFee=" + gnrlMgmtFee + ", cleanFee="
				+ cleanFee + ", elvtrMnfee=" + elvtrMnfee + ", genElctr=" + genElctr + ", comonElctr=" + comonElctr
				+ ", genWater=" + genWater + ", sewer=" + sewer + ", expenses=" + expenses + ", genReduction="
				+ genReduction + ", periodPayment=" + periodPayment + ", dueDate=" + dueDate + ", mgmtStartDate="
				+ mgmtStartDate + ", mgmtEndDate=" + mgmtEndDate + ", mgmtWriteDate=" + mgmtWriteDate + ", isPayment="
				+ isPayment + ", isOverdue=" + isOverdue + "]";
	}

	
}
