package com.location.management.controller;

import com.location.management.dto.UserDTO;
import com.location.management.exception.BusinessException;
import com.location.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
     private UserService userService;

     @PostMapping("/users")
     public ResponseEntity<Boolean> login(@RequestBody UserDTO userDTO) throws BusinessException {
         boolean result = userService.login(userDTO);
         ResponseEntity<Boolean> responseEntity  = new ResponseEntity<>(result, HttpStatus.OK);

         return responseEntity;
     }

    @PostMapping("/users/register")
    public ResponseEntity<Long> register(@RequestBody UserDTO userDTO) throws BusinessException {
        Long result = userService.register(userDTO);
        ResponseEntity<Long> responseEntity  = new ResponseEntity<>(result, HttpStatus.CREATED);

        return responseEntity;
    }

}
