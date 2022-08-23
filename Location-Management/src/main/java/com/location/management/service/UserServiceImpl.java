package com.location.management.service;

import com.location.management.ErrorType;
import com.location.management.converter.UserEntityConverter;
import com.location.management.dto.UserDTO;
import com.location.management.entity.UserEntity;
import com.location.management.exception.BusinessException;
import com.location.management.exception.ErrorModel;
import com.location.management.repository.UserEntityRepository;
import com.location.management.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserEntityRepository userRepository;
    @Autowired
    private UserEntityConverter userEntityConverter;
    @Autowired
    private UserValidator userValidator;

    @Override
    public boolean login(UserDTO userDTO) throws BusinessException {
        List<ErrorModel> errorModelList = userValidator.validateRequest(userDTO);
        if(CollectionUtils.isEmpty(errorModelList)){
            throw new BusinessException(errorModelList);
        }

        boolean result = false;
        UserEntity userEntity = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        if(userEntity==null){
            List<ErrorModel> errorList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(ErrorType.AUTH_BAD_CREDENTIALS.toString());
            errorModel.setMessage("Incorrect email or password");
            errorList.add(errorModel);
            throw new BusinessException(errorList);
        }else{
            result = true;
        }
        return result;
    }

    @Override
    public Long register(UserDTO userDTO) throws BusinessException{

        List<ErrorModel> errorModelList = userValidator.validateRequest(userDTO);
        if(CollectionUtils.isEmpty(errorModelList)){
            throw new BusinessException(errorModelList);
        }
        UserEntity ue = userRepository.findByEmail(userDTO.getEmail());
        if(null != ue){
            List<ErrorModel> errorList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(ErrorType.ALREADY_EXIST.toString());
            errorModel.setMessage("User with this email already exist, try another email");
            errorList.add(errorModel);
            throw new BusinessException(errorList);
        }

        UserEntity userEntity = userEntityConverter.convertDTOToEntity(userDTO);
        UserEntity userEntity1 = userRepository.save(userEntity);

            return userEntity1.getId();
    }
}
