package com.objectville.ecom.productService.commons;


import com.objectville.ecom.productService.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public UserDto validateToken(String tokenValue) {
        // call user service to validate token


        ResponseEntity<UserDto> response = restTemplate
                .getForEntity("http://localhost:4141/users/validate/" + tokenValue,
                        UserDto.class);

        if (response.getBody() == null) {
            return null;
        }
        return response.getBody();
    }
}
