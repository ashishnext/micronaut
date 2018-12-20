package taskmanager.clientOperations;

import io.reactivex.Flowable;
import taskmanager.classes.User;
import taskmanager.classes.UserCO;

import java.util.Optional;


public interface UserOperations {

    Flowable<User> create(UserCO userCO);

    Flowable<User> findAll();

    Flowable<User> fallbackFindAll();
}
