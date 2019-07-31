package com.kerimsamimi.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kerimsamimi.issuemanagement.dto.ProjectDto;
import com.kerimsamimi.issuemanagement.entity.Project;
import com.kerimsamimi.issuemanagement.util.TPage;

public interface ProjectService {
	
	ProjectDto save(ProjectDto project);
	
	ProjectDto getById(Long id);
	
	Project getByProjectCode(String projectCode);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	TPage<ProjectDto> getAllPageable(Pageable pageable);
	
	Boolean delete(Long id);
	
	ProjectDto update(Long id, ProjectDto project);

}
