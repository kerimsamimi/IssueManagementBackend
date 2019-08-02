package com.kerimsamimi.issuemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kerimsamimi.issuemanagement.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
	List<IssueHistory> getByIssueIdOrderById(Long id);
}
