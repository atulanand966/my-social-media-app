package com.socialmedia.mysocialmediaapp.exceptions;

public class UserRestExceptionResponse {

	private long timestamp;
	private String message;
	private String details;

	public UserRestExceptionResponse() {
	}

	public UserRestExceptionResponse(long timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "UserRestExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details
				+ "]";
	}

}
