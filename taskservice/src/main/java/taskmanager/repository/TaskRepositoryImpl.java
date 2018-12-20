package taskmanager.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.http.annotation.Body;
import taskmanager.domain.Task;
import taskmanager.model.TaskTO;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;

@Singleton
public class TaskRepositoryImpl implements TaskRepository{

    @PersistenceContext
    private EntityManager entityManager;

    TaskRepositoryImpl(){}

    TaskRepositoryImpl(@CurrentSession EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Task save(@NotBlank @Body TaskTO taskTO){
        System.out.println("=======Creating task=======");
        Task taskCReatedByUser = new Task(taskTO);
        entityManager.persist(taskCReatedByUser);
        return taskCReatedByUser;
    }

}
