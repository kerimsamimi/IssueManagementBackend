package com.kerimsamimi.issuemanagement.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kerimsamimi.issuemanagement.dto.IssueDetailDto;
import com.kerimsamimi.issuemanagement.dto.IssueDto;
import com.kerimsamimi.issuemanagement.dto.IssueHistoryDto;
import com.kerimsamimi.issuemanagement.dto.IssueUpdateDto;
import com.kerimsamimi.issuemanagement.entity.Issue;
import com.kerimsamimi.issuemanagement.entity.IssueStatus;
import com.kerimsamimi.issuemanagement.entity.User;
import com.kerimsamimi.issuemanagement.repository.IssueRepository;
import com.kerimsamimi.issuemanagement.repository.ProjectRepository;
import com.kerimsamimi.issuemanagement.repository.UserRepository;
import com.kerimsamimi.issuemanagement.service.IssueHistoryService;
import com.kerimsamimi.issuemanagement.service.IssueService;
import com.kerimsamimi.issuemanagement.util.TPage;

@Service
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IssueHistoryService issueHistoryService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	

	@Override
	public IssueDto save(IssueDto issue) {
		issue.setDate(new Date());
		issue.setIssueStatus(IssueStatus.OPEN);
        
        Issue issueEntity = modelMapper.map(issue, Issue.class);
        
        issueEntity.setProject(projectRepository.getOne(issue.getProjectId()));
        issueEntity = issueRepository.save(issueEntity);

        issue.setId(issueEntity.getId());
        return issue;
    }
	
	@Transactional
    public IssueDetailDto update(Long id, IssueUpdateDto issue) {
        Issue issueDb = issueRepository.getOne(id);
        User user = userRepository.getOne(issue.getAssignee_id());
        issueHistoryService.addHistory(id,issueDb);

        issueDb.setAssignee(user);
        issueDb.setDate(issue.getDate());
        issueDb.setDescription(issue.getDescription());
        issueDb.setDetails(issue.getDetails());
        issueDb.setIssueStatus(issue.getIssueStatus());
        issueDb.setProject(projectRepository.getOne(issue.getProject_id()));
        issueRepository.save(issueDb);
        return getByIdWithDetails(id);
    }

	@Override
	public IssueDto getById(Long id) {
		Issue issue =issueRepository.getOne(id);
		
		return modelMapper.map(issue, IssueDto.class);
	}
	
	public IssueDetailDto getByIdWithDetails(Long id) {
        Issue issue = issueRepository.getOne(id);
        IssueDetailDto detailDto = modelMapper.map(issue, IssueDetailDto.class);
        List<IssueHistoryDto> issueHistoryDtos = issueHistoryService.getByIssueId(issue.getId());
        detailDto.setIssueHistories(issueHistoryDtos);
        return detailDto;
    }

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<IssueDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return response;
	}

	@Override
	public Boolean delete(Long issueId) {
		issueRepository.deleteById(issueId);
		return true;
	}

	@Override
	public IssueDto update(Long id, IssueDto project) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
