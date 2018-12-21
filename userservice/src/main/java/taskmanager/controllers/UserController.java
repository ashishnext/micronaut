package taskmanager.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.tracing.annotation.NewSpan;
import io.micronaut.tracing.annotation.SpanTag;
import taskmanager.domain.User;
import taskmanager.models.UserTO;
import taskmanager.repository.UserRepositoryImpl;

import java.util.List;

@Controller("/user")
public class UserController{

    protected final UserRepositoryImpl userRepository;

    public UserController(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
    }

    @Post("/register")
    @NewSpan
    public HttpResponse<User> register(@SpanTag("userTo") @Body UserTO userTO){
        System.out.println("========registering user ================"+userRepository);
        System.out.println("UserTO ======== " + userTO.getUsername());
        return HttpResponse.created(userRepository.save(userTO));
    }

    @Get("/retrieve")
    @NewSpan
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @Get("/retrieve/retry")
    @NewSpan
    public List<User> retryRetrieveAllUsers(){
        return userRepository.retryFindAll();
    }


//    @Post("/{id}/task/create")
//    public HttpResponse<TaskTO> createTask(@Body TaskTO taskTO){
//
//    }


}
