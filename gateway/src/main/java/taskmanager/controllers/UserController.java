package taskmanager.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;
import jdk.nashorn.internal.parser.JSONParser;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;
import taskmanager.clientOperations.UserOperations;

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
}
