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
import com.udemy.issuemanagement.util.TPage;

import java.util.Arrays;
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
        Project proj = modelMapper.map(project, Project.class);
        User user = userRepository.getOne(project.getManagerId());
        proj.setManager(user);
        // saving the project
        proj = projectRepository.save(proj);
        proj.setId(proj.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project pro = projectRepository.getOne(id);
        return modelMapper.map(pro, ProjectDto.class);
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
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }


    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }


    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if(projectDb == null){
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);
        }
        // checking if the project already exists
        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCheck != null){
            throw new IllegalArgumentException("Project Code Already Exist");
        }
        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        // saving the project
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }

    public List<ProjectDto> getAll() {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ProjectDto[].class));
    }


}
