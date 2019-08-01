package com.kerimsamimi.issuemanagement.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Api(value="Project Data Transfer Onject")
public class ProjectDto {
	@ApiModelProperty(value="Project ID")
	private Long id;
	@NotNull
	@ApiModelProperty(required = true,value="Name of Project")
	private String projectName;
	@NotNull
	@ApiModelProperty(required = true,value="Code of Project")
	private String projectCode;
	
	@NotNull
	@ApiModelProperty(required = true,value="Id of Manager")
	private Long managerId;
	
	@ApiModelProperty(required = true,value="Name of Manager")
	private UserDto manager;
	
	
	
	
	public UserDto getManager() {
		return manager;
	}
	public void setManager(UserDto manager) {
		this.manager = manager;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
}
