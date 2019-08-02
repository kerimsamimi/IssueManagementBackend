package com.kerimsamimi.issuemanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kerimsamimi.issuemanagement.dto.ProjectDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "issue")
@NoArgsConstructor
@AllArgsConstructor
public class Issue extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="description", length = 300)
	private String description;
	
	@Column(name="date", length = 300)
	private Date date;
	
	@Column(name="issue_status", length = 300)
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
	@Column(name="details", length = 300)
	private String details;
	
	@JoinColumn(name = "assignee_user_id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private User assignee;
	
	@JoinColumn(name = "project_id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
	
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

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

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	
}
