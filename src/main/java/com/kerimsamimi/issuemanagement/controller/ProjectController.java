package com.kerimsamimi.issuemanagement.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kerimsamimi.issuemanagement.dto.ProjectDto;
import com.kerimsamimi.issuemanagement.service.impl.ProjectServiceImpl;
import com.kerimsamimi.issuemanagement.util.ApiPaths;
import com.kerimsamimi.issuemanagement.util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


//@CrossOrigin
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value =  ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {
	
	final static Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;
	
	@GetMapping("/pagination")
	@ApiOperation(value="Get By Pagination Operation", response = ProjectDto.class)
	public ResponseEntity<TPage<ProjectDto>> getAllPagination(Pageable pageable){
		TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping()
	@ApiOperation(value="Get All Operation", response = ProjectDto.class, responseContainer = "List")
	public ResponseEntity<List<ProjectDto>> getAll(){
		List<ProjectDto> data = projectServiceImpl.getAll();
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Get By Id Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable(required = true) Long id){
		logger.info("[ProjectController -> GetById]");
		ProjectDto projectDto= projectServiceImpl.getById(id);
		return ResponseEntity.ok(projectDto);
	}
	
	@PostMapping
	@ApiOperation(value="Create Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
		logger.info("[ProjectController -> Create Project Operation]");
		return ResponseEntity.ok(projectServiceImpl.save(project));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Update Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(required = true) Long id, @Valid @RequestBody ProjectDto project){
		logger.info("[ProjectController ->Update Project Operation]");
		return ResponseEntity.ok(projectServiceImpl.update(id,project));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> delete(@PathVariable(required = true) Long id) {
		logger.info("[ProjectController -> Delete Project Operation]");
		return ResponseEntity.ok(projectServiceImpl.delete(id));
	}
	
	
}
