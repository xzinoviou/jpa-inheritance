package com.xzinoviou.jpainheritance.project;

import com.xzinoviou.jpainheritance.developer.Developer;
import com.xzinoviou.jpainheritance.employee.Employee;
import com.xzinoviou.jpainheritance.employee.EmployeeService;
import com.xzinoviou.jpainheritance.manager.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Xenofon Zinoviou
 */
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final EmployeeService employeeService;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found: " + id));
    }

    public Project create(ProjectCreateRequest request) {

        Project project = new Project();
        project.setTitle(request.getTitle());


        if (!request.getProjectMembersIds().isEmpty()) {

            for (Long id : request.getProjectMembersIds()) {
                Employee employee = employeeService.getById(id);

                ProjectMember projectMember = createProjectMember(employee, project);

                project.addMember(projectMember);

            }
        }

        project.setProjectMembers();

        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    private ProjectMember createProjectMember(Employee employee, Project project) {
        ProjectMember projectMember;

        if (employee.isManager()) {
            Manager manager = (Manager) employee;

            projectMember = new ProjectMember(manager, project);
            projectMember.setOwner(true);

        } else {
            Developer developer = (Developer) employee;
            projectMember = new ProjectMember(developer, project);
        }

        return projectMember;
    }
}
