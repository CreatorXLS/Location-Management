package com.location.management.validator;

import com.location.management.ErrorType;
import com.location.management.dto.UserDTO;
import com.location.management.exception.ErrorModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator{

    public List<ErrorModel> validateRequest(UserDTO userDTO){
        List<ErrorModel> errorModelList = new ArrayList<>();
        if(null != userDTO && userDTO.getEmail() == null){
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(ErrorType.NOT_EMPTY.toString());
            errorModel.setMessage("email cannot be empty");
            errorModelList.add(errorModel);
        }
        if(null != userDTO && userDTO.getPassword() == null){
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode(ErrorType.NOT_EMPTY.toString());
            errorModel.setMessage("password cannot be empty");
            errorModelList.add(errorModel);
        }
        return errorModelList;
    }
}
