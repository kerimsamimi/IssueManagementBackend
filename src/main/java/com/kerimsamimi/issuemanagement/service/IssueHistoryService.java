package com.kerimsamimi.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kerimsamimi.issuemanagement.dto.IssueHistoryDto;
import com.kerimsamimi.issuemanagement.entity.Issue;
import com.kerimsamimi.issuemanagement.entity.IssueHistory;
import com.kerimsamimi.issuemanagement.util.TPage;

public interface IssueHistoryService {
	
	IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    List<IssueHistoryDto> getByIssueId(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

    void addHistory(Long id, Issue issue);

}
