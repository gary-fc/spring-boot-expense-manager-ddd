package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user;

import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerDomain.repositories.UserRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category.CategoryCrudRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.utils.CategoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserJpaRepository implements UserRepository {

    @Autowired
    private UserCrudRepository _userCrudRepository;

    @Autowired
    private CategoryCrudRepository _categoryCrudRepository;

    @Override
    public UUID create(User user) {

        UserJpaModel userJpaModel = new UserJpaModel();
        userJpaModel.setFirstName(user.getFirstName());
        userJpaModel.setLastName(user.getLastName());
        userJpaModel.setEmail(user.getEmail());
        userJpaModel.setId(user.getId());
        userJpaModel.setPassword(user.getPassword());
        userJpaModel.setCategories(CategoryUtils.mapToJpaEntityList(user.getCategories()));
        return _userCrudRepository.save(userJpaModel).getId();
    }
}
