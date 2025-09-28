package com.todoapp.controller;

import com.todoapp.model.Task;
import com.todoapp.respository.TaskRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskrepository;

    public TaskController (TaskRepository taskrepo){
        this.taskrepository = taskrepo;

    }

    @GetMapping
    public List<Task> getAlltasks(){
        return taskrepository.findAll();
    }

    @PostMapping
    public Task CreateTask(@RequestBody Task task){
        return taskrepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskrepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task newTask){
        return taskrepository.findById(id).map(
            task ->{
                task.setTitle(newTask.getTitle());
                task.setCompleted(newTask.isCompleted());
                return taskrepository.save(task);
            }
        )
        .orElseThrow(()-> new RuntimeException("Id does not Exist...."));
    }
}