package taskmanager.controller;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import taskmanager.domain.Task;
import taskmanager.model.TaskTO;
import taskmanager.repository.TaskRepositoryImpl;

@Controller(value = "/task")
public class TaskController {

    protected final TaskRepositoryImpl taskRepository;

    TaskController(TaskRepositoryImpl taskRepository){
        this.taskRepository = taskRepository;
    }

    @Post("/create")
    public HttpResponse<Task> createTask(TaskTO taskTO){
        return HttpResponse.created(taskRepository.save(taskTO));
    }
}
