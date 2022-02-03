package com.jasonsystem.demo.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userId;
    private String password;
    private String name;
    private String roleCd;
}
