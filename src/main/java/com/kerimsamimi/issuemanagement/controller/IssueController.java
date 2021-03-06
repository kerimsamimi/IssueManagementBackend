package com.kerimsamimi.issuemanagement.controller;

import java.util.Arrays;
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
import com.kerimsamimi.issuemanagement.dto.IssueDetailDto;
import com.kerimsamimi.issuemanagement.dto.IssueDto;
import com.kerimsamimi.issuemanagement.dto.IssueUpdateDto;
import com.kerimsamimi.issuemanagement.entity.IssueStatus;
import com.kerimsamimi.issuemanagement.service.impl.IssueServiceImpl;
import com.kerimsamimi.issuemanagement.util.ApiPaths;
import com.kerimsamimi.issuemanagement.util.TPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value =  ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")
@CrossOrigin
public class IssueController {
	
	final static Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private IssueServiceImpl issueServiceImpl;
	
	@GetMapping("/pagination")
	@ApiOperation(value="Get By Pagination Operation", response = IssueDto.class)
	public ResponseEntity<TPage<IssueDto>> getAllPagination(Pageable pageable){
		TPage<IssueDto> data = issueServiceImpl.getAllPageable(pageable);
		return ResponseEntity.ok(data);
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="Get By Id Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable(required = true) Long id){
		logger.info("[IssueController -> GetById]");
		IssueDto issueDto= issueServiceImpl.getById(id);
		return ResponseEntity.ok(issueDto);
	}
	
	@GetMapping("/detail/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDetailDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
        IssueDetailDto detailDto = issueServiceImpl.getByIdWithDetails(id);
        return ResponseEntity.ok(detailDto);
    }
	
	@PostMapping
	@ApiOperation(value="Create Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue){
		logger.info("[IssueController -> Create Issue Operation]");
		return ResponseEntity.ok(issueServiceImpl.save(issue));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Update Operation", response = IssueDto.class)
	public ResponseEntity<IssueDetailDto> updateProject(@PathVariable(required = true) Long id, @Valid @RequestBody IssueUpdateDto issue){
		
		return ResponseEntity.ok(issueServiceImpl.update(id, issue));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> delete(@PathVariable(required = true) Long id) {
		logger.info("[IssueController -> Delete Issue Operation]");
		return ResponseEntity.ok(issueServiceImpl.delete(id));
	}
	
	@GetMapping("/statuses")
    @ApiOperation(value = "Get All Issue Statuses Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<IssueStatus>> getAll() {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values()));
    }
	
}
