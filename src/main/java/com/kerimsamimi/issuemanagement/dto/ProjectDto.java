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
