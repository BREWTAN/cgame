package onight.tfw.rest.web.bean;

import lombok.Data;

public @Data class MailInfo {
	private String sendTo;
	private String sendSubject;
	private String sendText;
}
