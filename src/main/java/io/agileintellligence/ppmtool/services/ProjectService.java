package io.agileintellligence.ppmtool.services;

import io.agileintellligence.ppmtool.domain.Project;
import io.agileintellligence.ppmtool.exeptions.ProjectIdExeption;
import io.agileintellligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdExeption("Project ID" + project.getProjectIdentifier().toUpperCase() + "already exists");

        }

    }
    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
    if (project==null){
        throw new ProjectIdExeption("Project ID" + projectId + "does not exists");

    }
        return project;
    }
    public Iterable<Project>findAllProject(){
        return projectRepository.findAll();
    }

public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);

        if (project == null){
            throw new ProjectIdExeption("Can't Project eith ID "+projectId+" This project doesn't exists");
        }

        projectRepository.delete(project);
}

}
