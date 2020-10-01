/**
 * 
 */
package com.vmb.enterprise.enums;

/**
 * @author pavanvejju
 *
 */
public enum ErrorCodeEnum {
	

	SUCCESS(0, "SUCCESS", "Success"),
	FAILURE(1000, "FAILURE", "Failure");
    
	public final int code;
	public final String strCode;
	public final String description;

    private ErrorCodeEnum(int code, String strCode, String description) {
 		this.code	=	code;
 		this.strCode	=	strCode;
 		this.description	=	description;
 	}


}
