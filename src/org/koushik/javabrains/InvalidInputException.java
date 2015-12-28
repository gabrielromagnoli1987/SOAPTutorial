package org.koushik.javabrains;

public class InvalidInputException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 263877506776627771L;
	private String errorDetails;
	
	public InvalidInputException(String reason, String errorDetails){
		super(reason);
		this.errorDetails = errorDetails;
	}
	
	public String getFaultInfo(){
		return errorDetails;
	}

}
