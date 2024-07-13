package com.authorize.authorize.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private String fullName;
    private String email;
    private String jwtToken;
    private Long expiresIn;
    private Date created_At;
//    private String role;

}
