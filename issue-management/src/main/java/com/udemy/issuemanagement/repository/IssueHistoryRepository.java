package com.udemy.issuemanagement.repository;

import com.udemy.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {

    List<IssueHistory> getByIssueIdOrderById(Long id);

}
