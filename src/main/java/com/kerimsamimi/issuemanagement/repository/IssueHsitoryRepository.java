package com.kerimsamimi.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kerimsamimi.issuemanagement.entity.IssueHistory;

public interface IssueHsitoryRepository extends JpaRepository<IssueHistory, Long> {

}
