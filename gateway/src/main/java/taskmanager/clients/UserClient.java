package taskmanager.clients;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Flowable;
import taskmanager.classes.UpdateUserCO;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;
import taskmanager.clientOperations.UserOperations;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Client("UserService")
public interface UserClient extends UserOperations {

    @Post("/user/register")
    Flowable<User> create(@Body UserCO userCO);

    @Get("/user/retrieve")
    Flowable<User> findAll();

    @Get("/user/retrieve/retry")
    Flowable<User> fallbackFindAll();

    @Put("/user/update")
    Flowable<User> update(@NotBlank @Body UpdateUserCO updateUserCO);

    @Delete("/user/delete")
    Boolean delete(@NotBlank @NotNull String username);

}
