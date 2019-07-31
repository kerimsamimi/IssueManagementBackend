package com.kerimsamimi.issuemanagement.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.kerimsamimi.issuemanagement.dto.IssueDto;
import com.kerimsamimi.issuemanagement.entity.Issue;
import com.kerimsamimi.issuemanagement.repository.IssueRepository;
import com.kerimsamimi.issuemanagement.service.IssueService;
import com.kerimsamimi.issuemanagement.util.TPage;

@Service
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public IssueDto save(IssueDto issue) {
		if(issue.getDate()==null) {
			throw new IllegalArgumentException("Issue Date cannot be null");
		}
		Issue issueDb= modelMapper.map(issue, Issue.class);
		
		issueDb= issueRepository.save(issueDb);
		return modelMapper.map(issueDb, IssueDto.class);
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue =issueRepository.getOne(id);
		
		return modelMapper.map(issue, IssueDto.class);
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
