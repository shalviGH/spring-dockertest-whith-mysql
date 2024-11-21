package com.testSpringBoot;

import java.util.List;

public interface UserService {
    UserEntity create(UserDTO userDTO);

    List<UserEntity> findAll();
}
