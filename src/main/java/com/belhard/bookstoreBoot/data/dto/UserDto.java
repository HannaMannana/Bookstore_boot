package com.belhard.bookstoreBoot.data.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Role roleType;

    public enum Role {
        ADMIN, MANAGER, CUSTOMER
    }

}
