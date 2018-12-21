package taskmanager.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import taskmanager.domain.User;
import taskmanager.models.UpdateUserTO;
import taskmanager.models.UserTO;
import taskmanager.repository.UserRepositoryImpl;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller("/user")
public class UserController{

    protected final UserRepositoryImpl userRepository;

    public UserController(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
    }

    @Post("/register")
    public HttpResponse<User> register(@Body UserTO userTO){
        System.out.println("========registering user ================"+userRepository);
        System.out.println("UserTO ======== " + userTO.getUsername());
        User user = userRepository.save(userTO);
        System.out.println("User =========== " + user.getUserName());
        return HttpResponse.created(user);
    }

    @Get("/retrieve")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @Get("/retrieve/retry")
    public List<User> retryRetrieveAllUsers(){
        return userRepository.retryFindAll();
    }

    @Put("/update")
    public HttpResponse<?> update(@NotBlank @Body UpdateUserTO updateUserTO) {
        System.out.println("========updating user ================"+userRepository);
        System.out.println("UserTO ======== " + updateUserTO.getUsername());
        User user = userRepository.update(updateUserTO);
        if (user != null) {
            return HttpResponse.ok(user);
        } else {
            return HttpResponse.serverError();
        }
    }

    @Delete("/delete")
    public Boolean delete(@NotBlank @NotNull String username) {
        System.out.println("========deleting user ================"+userRepository);
        return userRepository.delete(username);
    }


}
