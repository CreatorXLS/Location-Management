package com.location.management.service;

import com.location.management.dto.UserDTO;
import com.location.management.exception.BusinessException;
import org.springframework.web.bind.annotation.ResponseBody;

public interface UserService {

    public boolean login(UserDTO userDTO) throws BusinessException;

    public Long register(UserDTO userDTO) throws BusinessException;


}
