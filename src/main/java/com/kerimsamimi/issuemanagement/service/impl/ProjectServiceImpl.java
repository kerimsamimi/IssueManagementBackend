package com.kerimsamimi.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kerimsamimi.issuemanagement.controller.ProjectController;
import com.kerimsamimi.issuemanagement.dto.ProjectDto;
import com.kerimsamimi.issuemanagement.entity.Project;
import com.kerimsamimi.issuemanagement.entity.User;
import com.kerimsamimi.issuemanagement.repository.ProjectRepository;
import com.kerimsamimi.issuemanagement.repository.UserRepository;
import com.kerimsamimi.issuemanagement.service.ProjectService;
import com.kerimsamimi.issuemanagement.util.TPage;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	final static Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	

	public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper,
			UserRepository userRepository) {
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}

	@Override
	public ProjectDto save(ProjectDto project) {
		
		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
		
		if(projectCheck!=null) {
			logger.error("[PROJECTCHECK CAN NOT BE NULL]");
			throw new IllegalArgumentException("Project Code Already Exist");	
		}
		Project p=modelMapper.map(project,Project.class);
		User user= userRepository.getOne(project.getManagerId());
		p.setManager(user);
		
		p=projectRepository.save(p);
		project.setId(p.getId());
		return project;
	}

	@Override
	public ProjectDto getById(Long id) {
		Project p= projectRepository.getOne(id);
		return modelMapper.map(p, ProjectDto.class);
	}

	@Override
	public Project getByProjectCode(String projectCode) {
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		return null;
	}

	@Override
	public TPage<ProjectDto> getAllPageable(Pageable pageable) {
		Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
	}

	@Override
	public Boolean delete(Long id) {
		 projectRepository.deleteById(id);
		 return true;
	}

	@Override
	public ProjectDto update(Long id, ProjectDto project) {
		
		Project projectDb= projectRepository.getOne(id);
		if(projectDb==null) 
			throw new IllegalArgumentException("Project Does Not Exist. ID:"+ id);
		
		Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
		if(projectCheck!=null)
			throw new IllegalArgumentException("Project Code Already Exist");
		
		projectDb.setProjectName(project.getProjectName());
		projectDb.setProjectCode(project.getProjectCode());
		
		projectRepository.save(projectDb);
		return modelMapper.map(projectDb,ProjectDto.class);
	}

	public List<ProjectDto> getAll() {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ProjectDto[].class));
    }

}
