package com.kerimsamimi.issuemanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kerimsamimi.issuemanagement.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	Page<Issue> findAll(Pageable pageable);

}
