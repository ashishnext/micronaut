package taskmanager.repository;

import io.micronaut.http.annotation.Body;
import io.micronaut.retry.annotation.Fallback;
import taskmanager.domain.User;
import taskmanager.models.UserTO;
import taskmanager.repository.UserRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Fallback
//public class UserFallback implements UserRepository {

//    public Optional<User> findById(@NotNull Long id) {return null;}
//
//    public User save(@NotBlank @Body UserTO userTO) {return null;}
//
//    public void deleteById(@NotNull Long id) {}
//
//    public void update(@NotNull Long id, @NotBlank @Body UserTO userTO) {
//    }
//
//    @Override
//    public List<User> findAll() {
//        System.out.println("Inside fallback method");
//        return new ArrayList<User>();
//    }
//}
