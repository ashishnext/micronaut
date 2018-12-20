package taskmanager.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.annotation.Body;
import io.micronaut.retry.annotation.Retryable;
import io.micronaut.spring.tx.annotation.Transactional;
import taskmanager.domain.User;
import taskmanager.models.UserTO;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Singleton
@Requires("entityManager")
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl(@CurrentSession EntityManager entityManager){
        System.out.println("=============Entitymanager=======>>>>>>>>>>>>"+entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<User> findById(@NotNull Long id){
        return Optional.ofNullable(entityManager.find(User.class,id));
    }

    @Override
    @Transactional(readOnly = false)
    public User save(@NotBlank @Body UserTO userTO){
        System.out.println("=========Created user========");
        User user = new User(userTO);
        entityManager.persist(user);
        return user;
    }

    @Retryable
    @Override
    @Transactional(readOnly = false)
    public List<User> findAll(){
        System.out.println("Inside findAll methodddd");
        String qlString = "SELECT u FROM User as u";
        TypedQuery<User> query = entityManager.createQuery(qlString, User.class);
        return query.getResultList();
    }

//    @Retryable
    @Override
    @Transactional(readOnly = false)
    public List<User> retryFindAll(){
        System.out.println("Inside retryFindAll methodddd");
        int i = 1/0;
        int j = i + 1;
        String qlString = "SELECT u FROM User as u";
        TypedQuery<User> query = entityManager.createQuery(qlString, User.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(@NotNull Long id){
        findById(id).ifPresent(user -> entityManager.remove(user));
    }

    @Override
    @Transactional(readOnly = false)
    public void update(@NotNull Long id, @NotBlank @Body UserTO userTO){
        User updatedUser = new User(userTO);
        findById(id).ifPresent(user ->entityManager.merge(updatedUser));
    }
}
