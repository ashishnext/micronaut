package taskmanager.clientOperations;

import io.micronaut.http.annotation.Body;
import io.reactivex.Flowable;
import taskmanager.classes.UpdateUserCO;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public interface UserOperations {

    Flowable<User> create(UserCO userCO);

    Flowable<User> findAll();

    Flowable<User> fallbackFindAll();

    Flowable<User> update(@NotBlank @Body UpdateUserCO updateUserCO);

    Boolean delete(@NotBlank @NotNull String username);
}
