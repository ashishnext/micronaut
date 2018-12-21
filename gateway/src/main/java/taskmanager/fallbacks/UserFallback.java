package taskmanager.fallbacks;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;
import taskmanager.classes.UpdateUserCO;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;
import taskmanager.clientOperations.UserOperations;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Fallback
public class UserFallback implements UserOperations {

    public Flowable<User> create(UserCO userCO) {return Flowable.empty();}

    public Flowable<User> findAll() {return Flowable.empty();}

    public Flowable<User> fallbackFindAll() {
        System.out.println("Inside fallback method. Returning empty list!");
        return Flowable.empty();
    }

    public Flowable<User> update(UpdateUserCO updateUserCO) {return Flowable.empty();}

    public Boolean delete(@NotBlank @NotNull String username) {return Boolean.FALSE;}

}
