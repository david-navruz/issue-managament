package com.udemy.issuemanagement.service;

import com.udemy.issuemanagement.dto.IssueHistoryDto;
import com.udemy.issuemanagement.entity.Issue;
import com.udemy.issuemanagement.entity.IssueHistory;
import com.udemy.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IssueHistoryService {

    IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    List<IssueHistoryDto> getByIssueId(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

    void addHistory(Long id, Issue issue);


}
