package com.vstech.service.clients;

import com.vstech.exception.UserException;
import com.vstech.payload.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("USER")
public interface UserFeignClient {

    @GetMapping("/api/users/profile")
    public ResponseEntity<UserDTO> getUserFromJwtToken(
            @RequestHeader("Authorization") String jwt) throws UserException;
}
