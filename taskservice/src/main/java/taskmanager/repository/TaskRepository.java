package taskmanager.repository;

import io.micronaut.http.annotation.Body;
import taskmanager.domain.Task;
import taskmanager.model.TaskTO;

import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;

public interface TaskRepository {

    Task save(@NotBlank @Body TaskTO taskTO);
}
