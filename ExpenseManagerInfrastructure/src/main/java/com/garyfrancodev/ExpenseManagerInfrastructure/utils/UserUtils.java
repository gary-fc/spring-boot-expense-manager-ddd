package com.garyfrancodev.ExpenseManagerInfrastructure.utils;

import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;

public class UserUtils {
    public static UserJpaModel mapToJpaEntity(User user){
        UserJpaModel userJpaModel = new UserJpaModel();
        userJpaModel.setId(user.getId());
        userJpaModel.setFirstName(user.getFirstName());
        userJpaModel.setLastName(user.getLastName());
        userJpaModel.setEmail(user.getEmail());
        userJpaModel.setPassword(user.getPassword());

        return userJpaModel;
    }
}
