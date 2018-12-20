package taskmanager.clients;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Flowable;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;
import taskmanager.clientOperations.UserOperations;

import java.util.Optional;

@Client("UserService")
public interface UserClient extends UserOperations {

    @Post("/user/register")
    Flowable<User> create(@Body UserCO userCO);

    @Get("/user/retrieve")
    Flowable<User> findAll();

    @Get("/user/retrieve/retry")
    Flowable<User> fallbackFindAll();

}
