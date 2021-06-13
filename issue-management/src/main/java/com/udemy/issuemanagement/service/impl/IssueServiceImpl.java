package com.udemy.issuemanagement.service.impl;

import com.udemy.issuemanagement.entity.Issue;
import com.udemy.issuemanagement.repository.IssueRepository;
import com.udemy.issuemanagement.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService {

    private IssueRepository issueRepository;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue getById(Long id) {
        return issueRepository.getOne(id);
    }

    @Override
    public Page<Issue> getAllPageable(Pageable pageable) {
        return issueRepository.findAll(pageable);
    }
}
