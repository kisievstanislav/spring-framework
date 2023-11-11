package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceIml implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceIml(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }


    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project> projectList = projectRepository.findAll(Sort.by("projectName"));
        return projectList.stream().map(projectMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO findByProjectCode(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        return projectMapper.convertToDTO(project);
    }

    @Override
    public void save(ProjectDTO dto) {
        if (dto.getProjectStatus() == null) {
            dto.setProjectStatus(Status.OPEN);
        }
        projectRepository.save(projectMapper.convertToEntity(dto));
    }

    @Override
    public ProjectDTO update(ProjectDTO dto) {
        //Find current user
        Project project = projectRepository.findByProjectCode(dto.getProjectCode());
        //Map updated user dto to entity object
        Project convertedProject = projectMapper.convertToEntity(dto);
        //set id to converted object
        convertedProject.setId(project.getId());
        //save updated user
        projectRepository.save(convertedProject);

        return findByProjectCode(dto.getProjectName());
    }


    @Override
    public void complete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }

    @Override
    public void delete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setIsDeleted(true);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
//        List<ProjectDTO> projectList =
//                listAllProjects()
//                        .stream()
//                        .filter(project -> project.getAssignedManager().equals(manager))
//                        .map(project -> {
//
//                            List<TaskDTO> taskList = taskService.findTasksByManager(manager);
//
//                            int completeTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETE).count();
//
//                            int unfinishedTaskCounts = (int) taskList.stream().filter(t -> t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETE).count();
//
//                            project.setCompleteTaskCounts(completeTaskCounts);
//                            project.setUnfinishedTaskCounts(unfinishedTaskCounts);
//
//                            return project;
//
//                        }).collect(Collectors.toList());
//
//
//        return projectList;

        return null;
    }


}
