package com.udemy.issuemanagement.service.impl;

import com.udemy.issuemanagement.dto.ProjectDto;
import com.udemy.issuemanagement.entity.Project;
import com.udemy.issuemanagement.entity.User;
import com.udemy.issuemanagement.repository.ProjectRepository;
import com.udemy.issuemanagement.repository.UserRepository;
import com.udemy.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ModelMapper modelMapper, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
        if(projectCheck != null){
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        Project p = modelMapper.map(project, Project.class);
        User user = userRepository.getOne(project.getManagerId());
        p.setm



        return null;
    }

    @Override
    public ProjectDto getById(Long id) {
        return null;
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        return null;
    }


}
