package com.kerimsamimi.issuemanagement.service;

import org.springframework.data.domain.Pageable;

import com.kerimsamimi.issuemanagement.dto.IssueDto;
import com.kerimsamimi.issuemanagement.util.TPage;


public interface IssueService {
	
	IssueDto save(IssueDto issue);
	
	IssueDto getById(Long id);
	
	TPage<IssueDto> getAllPageable(Pageable pageable);
	
	Boolean delete(Long issueId);
	
	IssueDto update(Long id, IssueDto project);

}
