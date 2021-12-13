package com.cyber.implementation;

import com.cyber.dto.TaskDTO;
import com.cyber.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getId(), object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO existingProject = findById(object.getId());
        object.setAssignedDate(existingProject.getAssignedDate());
        object.setTaskStatus(existingProject.getTaskStatus());

        super.update(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }
}
