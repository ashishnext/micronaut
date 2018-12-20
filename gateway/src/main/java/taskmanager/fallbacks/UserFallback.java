package taskmanager.fallbacks;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Flowable;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;
import taskmanager.clientOperations.UserOperations;

@Fallback
public class UserFallback implements UserOperations {

    public Flowable<User> create(UserCO userCO) {return null;}

    public Flowable<User> findAll() {return null;}

    public Flowable<User> fallbackFindAll() {
        System.out.println("Inside fallback method. Returning empty list!");
        return Flowable.empty();
    }
}
