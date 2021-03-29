package com.ex.shop.service;

import com.ex.shop.model.service.UserServiceModel;

public interface UserService {

    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
