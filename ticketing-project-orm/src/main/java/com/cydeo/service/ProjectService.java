package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> listAllProjects();
    ProjectDTO findByProjectCode(String projectCode);
    void save(ProjectDTO dto);
    ProjectDTO update(ProjectDTO dto);
    void delete(String projectName);
    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);
    void complete(String project);


}
