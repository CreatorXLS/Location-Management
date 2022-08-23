package com.location.management.converter;

import com.location.management.dto.UserDTO;
import com.location.management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {

    public UserEntity convertDTOToEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setMobileNumber(userDTO.getMobileNumber());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }

}
