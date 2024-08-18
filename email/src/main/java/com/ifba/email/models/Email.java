package com.ifba.email.models;

import java.time.LocalDateTime;

import com.ifba.email.dto.EmailDto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="emails")
public class Email {

	public Email(EmailDto dto) {
		this.mailFrom = dto.mailFrom();
		this.mailTo = dto.mailTo();
		this.mailSubject = dto.mailSubject();
		this.mailText = dto.mailText();
	}
	
	public Email(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mailFrom;
	private String mailTo;
	private String mailSubject;
	private String mailText;
	private LocalDateTime sendDateEmail;
	@Enumerated(EnumType.STRING)
	private EmailStatus status = EmailStatus.SENT;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getMailText() {
		return mailText;
	}
	public void setMailText(String mailText) {
		this.mailText = mailText;
	}
	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}
	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}
	public EmailStatus getStatus() {
		return status;
	}
	public void setStatus(EmailStatus status) {
		this.status = status;
	}
	
}
