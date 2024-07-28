package com.vmb.enterprise.enums;

public enum TransactionTypeEnum {
		DEBIT("DEBIT",0,"Debit Type"),
		CREDIT("CREDIT",0,"Credit Type");

		public final int code;
		public final String strCode;
		public final String description;
	    TransactionTypeEnum(String strCode,int code,  String description) {
	 		this.strCode	=	strCode;
	 		this.code	=	code;
	 		this.description	=	description;
	 	}
	}