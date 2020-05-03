package com.assignment.LightningTalks.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;




@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer topicId;
	@Column(unique = true)
	@NotBlank(message = "Topic is mandatory")
	private String topicName;
	@NotBlank(message = "Topic Description is mandatory")
	@Pattern(message="Topic description cannot be more than 80 words.", regexp="^(\\b[a-zA-Z\\d+#.'-]+\\b(?:\\s+|$)){0,80}$")
	private String topicDescription;
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email is not valid")
	private String emailAddress;
	@CreationTimestamp
	private LocalDateTime submissionDate;
	private LocalDate lightningTalkDate;
	private String ipAddress;
	private String hostName;
	private String operatingSystem;
	private String browserType;
	
	public Integer getTopicId() {
		return topicId;
	}


	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}


	public String getTopicName() {
		return topicName;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}


	public String getTopicDescription() {
		return topicDescription;
	}


	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public LocalDate getLightningTalkDate() {
		return lightningTalkDate;
	}


	public void setLightningTalkDate(LocalDate lightningTalkDate) {
		this.lightningTalkDate = lightningTalkDate;
	}


	public String getIpAddress() {
		return ipAddress;
	}


	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


	public String getHostName() {
		return hostName;
	}


	public void setHostName(String hostName) {
		this.hostName = hostName;
	}


	public String getOperatingSystem() {
		return operatingSystem;
	}


	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}


	public String getBrowserType() {
		return browserType;
	}


	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}
	

	public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}


	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}


	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", topicDescription=" + topicDescription
				+ ", emailAddress=" + emailAddress + ", submissionDate=" + submissionDate + ", lightningTalkDate="
				+ lightningTalkDate + ", ipAddress=" + ipAddress + ", hostName=" + hostName + ", operatingSystem="
				+ operatingSystem + ", browserType=" + browserType + "]";
	}
	
	
	
}
