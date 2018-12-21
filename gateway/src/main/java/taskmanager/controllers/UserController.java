package taskmanager.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import io.micronaut.http.annotation.*;
import io.micronaut.tracing.annotation.NewSpan;
import io.reactivex.Flowable;
import jdk.nashorn.internal.parser.JSONParser;
import taskmanager.classes.UpdateUserCO;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;
import taskmanager.clientOperations.UserOperations;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller
public class UserController {

    private final UserOperations userOperations;

    UserController(UserOperations userOperations) {
        this.userOperations = userOperations;
    }

    @Post("/api/user")
    public Flowable<User> createUser(@Body UserCO userCO) {
        System.out.println("UserCo ========= " + userCO.getUsername());
        return userOperations.create(userCO);
    }

    @NewSpan
    @Get("/api/users")
    public Flowable<User> findAllUsers() {
        System.out.println("Fetching all users");
        return userOperations.findAll();
    }

    @Get("/api/users/fallback")
    public Flowable<User> fallbackFindAllUsers() {
        System.out.println("Fetching all users");
        return userOperations.fallbackFindAll();
    }

    @Put("/api/user")
    public Flowable<User> updateUser(@Body UpdateUserCO updateUserCO) {
        System.out.println("UserCo ========= " + updateUserCO.getUsername());
        return userOperations.update(updateUserCO);
    }

    @Delete("/api/user")
    public Boolean deleteUser(@NotBlank @NotNull String username) {
        System.out.println("Deleting user ========= " + username);
        return userOperations.delete(username);
    }
}
