package taskmanager.repository;

import io.micronaut.http.annotation.Body;
import io.micronaut.retry.annotation.CircuitBreaker;
import io.micronaut.retry.annotation.Retryable;
import taskmanager.domain.User;
import taskmanager.models.UpdateUserTO;
import taskmanager.models.UserTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(@NotNull Long id);

    Optional<User> findByUsername(@NotNull String username);

    User save(@NotBlank @Body UserTO userTO);

    void deleteById(@NotNull Long id);

    User update(@NotBlank @Body UpdateUserTO updateUserTO);

    Boolean delete(@NotBlank @NotNull String username);

    List<User> findAll();

    @Retryable
    List<User> retryFindAll();
}