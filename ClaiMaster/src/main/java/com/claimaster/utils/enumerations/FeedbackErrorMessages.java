package com.claimaster.utils.enumerations;

public enum FeedbackErrorMessages {
	
	BUTTON_UNAVAILABLE ("Button is not available"), 
	POPUP_NOT_LOADED ("poup is not loaded"), 
	SHOULD_NOT_NAVIGATE ("User navigated to different page");
	
	private String value;
	 
	private FeedbackErrorMessages(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
