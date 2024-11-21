package com.testSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRespository userRespository;


    @Override
    public UserEntity create(UserDTO userDTO) {
        UserEntity user = new UserEntity();

        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());

        userRespository.save(user);

        return user;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRespository.findAll();
    }
}
