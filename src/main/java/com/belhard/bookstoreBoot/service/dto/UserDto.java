package com.belhard.bookstoreBoot.service.dto;

import com.belhard.bookstoreBoot.data.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private User.Role roleType;


    @Override
    public String toString() {
        return "\n UserDto" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", email= '" + email + '\'' +
                ", password= '" + password + '\'' +
                ", roleType= " + roleType;
    }
}
