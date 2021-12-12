package com.cyber.controller;

import com.cyber.dto.ProjectDTO;
import com.cyber.enums.Status;
import com.cyber.service.ProjectService;
import com.cyber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService; // we just basically put all the users as managers !!

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers",userService.findManagers()); // assign managers
        model.addAttribute("projects",projectService.findAll());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project, Model model){
        projectService.save(project);
        project.setProjectStatus(Status.OPEN);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model){

        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("managers",userService.findManagers());
        model.addAttribute("projects",projectService.findAll());

        return "/project/update";
    }

    @PostMapping ("/update/{projectCode}")
    public String updateProject(@PathVariable("projectCode") String projectCode, ProjectDTO project, Model model){
        projectService.update(project);
        return "redirect:/project/create";
    }
}
