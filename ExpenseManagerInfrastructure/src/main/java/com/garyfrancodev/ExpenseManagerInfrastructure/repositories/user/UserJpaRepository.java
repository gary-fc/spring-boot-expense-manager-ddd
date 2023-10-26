package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user;

import com.garyfrancodev.ExpenseManagerDomain.factories.user.CreateUser;
import com.garyfrancodev.ExpenseManagerDomain.factories.user.UserFactory;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerDomain.repositories.UserRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserJpaRepository implements UserRepository {

    @Autowired
    private UserCrudRepository _userCrudRepository;

    private final UserFactory userFactory;

    public UserJpaRepository() {
        this.userFactory = new CreateUser();
    }

    @Override
    public UUID create(User user) {
//        user.getDomainEvents()
        UserJpaModel userJpaModel = new UserJpaModel();
        userJpaModel.setId(user.getId());
        userJpaModel.setFirstName(user.getFirstName());
        userJpaModel.setLastName(user.getLastName());
        userJpaModel.setEmail(user.getEmail());
        userJpaModel.setPassword(user.getPassword());
        return _userCrudRepository.save(userJpaModel).getId();
    }

    @Override
    public User findId(UUID id) {
        UserJpaModel userJpaModel = _userCrudRepository.findById(id).orElseThrow();
        return userFactory.create(userJpaModel.getFirstName(), userJpaModel.getLastName(), userJpaModel.getEmail(), userJpaModel.getPassword());
    }
}
