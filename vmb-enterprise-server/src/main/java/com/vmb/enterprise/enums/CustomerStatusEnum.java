package com.vmb.enterprise.enums;

public enum CustomerStatusEnum {
	

		
		ACTIVE("ACTIVE",0,"User Status is Active"),
		INACTIVE("INACTIVE",0,"User Status is InActive"),
		CLOSED("CLOSED",0,"User Status is Closed");
		
		
		public final int code;
		public final String strCode;
		public final String description;
	    CustomerStatusEnum(String strCode,int code,  String description) {
	 		
	 		this.strCode	=	strCode;
	 		this.code	=	code;
	 		this.description	=	description;
	 	}
	}
