package com.udemy.issuemanagement.service;

import com.udemy.issuemanagement.dto.IssueDto;
import com.udemy.issuemanagement.entity.Issue;
import com.udemy.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issue);

    IssueDto update(Long id, IssueDto project);

}
