package com.emp.app.model;

import java.io.Serializable;

public class ErrorTextVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5916978139525454640L;
	private String errorCode;
	private String errorText;
	private String severity;
	
	public ErrorTextVo(){
		
	}
	public ErrorTextVo(String errorCode,String errorText,String severity){
		this.errorCode = errorCode;
		this.errorText = errorText;
		this.severity = severity;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
}
