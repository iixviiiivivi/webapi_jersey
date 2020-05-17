package webapi.jersey.exception;

import jakarta.ws.rs.core.Response.Status;

public class ResponseMessage {

	private int statusCode;
	private Status statusCodeName;
	private String statusmessage;
	
	public ResponseMessage() {
		super();
	}

	public ResponseMessage(int statusCode, Status statusCodeName, String statusmessage) {
		super();
		this.statusCode = statusCode;
		this.statusCodeName = statusCodeName;
		this.statusmessage = statusmessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Status getStatusCodeName() {
		return statusCodeName;
	}

	public void setStatusCodeName(Status statusCodeName) {
		this.statusCodeName = statusCodeName;
	}

	public String getStatusmessage() {
		return statusmessage;
	}

	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}
	
}
