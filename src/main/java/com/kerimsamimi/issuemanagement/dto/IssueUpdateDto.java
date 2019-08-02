package com.kerimsamimi.issuemanagement.dto;

import java.util.Date;

import com.kerimsamimi.issuemanagement.entity.IssueStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Issue Data Transfer Object")
public class IssueUpdateDto {
	@ApiModelProperty(value="Issue Id")
	private Long id;
	@ApiModelProperty(required = true,value="Description")
	private String description;
	@ApiModelProperty(required = true,value="Details")
	private String details;
	@ApiModelProperty(required = true,value="Date")
	private Date date;
	@ApiModelProperty(required = true,value="Issue Status")
	private IssueStatus issueStatus;
	@ApiModelProperty(required = true,value="Assignee")
	private Long assignee_id;
	@ApiModelProperty(required = true,value="Project")
	private Long project_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public IssueStatus getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}
	public Long getAssignee_id() {
		return assignee_id;
	}
	public void setAssignee_id(Long assignee_id) {
		this.assignee_id = assignee_id;
	}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	
	
	
}
