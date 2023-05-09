package com.belhard.bookstoreBoot.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_bh")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_user")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password_user")
    private String password;

    @Column(name = "role_id")
    @Convert(converter = RoleConverter.class)
    private Role roleType;

    public enum Role {
        ADMIN, MANAGER, CUSTOMER
    }

    @Converter
    public static class RoleConverter implements AttributeConverter<Role, Short>{

        @Override
        public Short convertToDatabaseColumn(Role role) {
            Role[] values = Role.values();
            for (short i = 0; i < values.length; i++) {
                if(values [i].equals(role)){
                    return (short) (i+1);
                }

            }
            return 1;
        }

        @Override
        public Role convertToEntityAttribute(Short integer) {
            Role[] values = Role.values();
            return values [integer-1];
        }
    }


    @Override
    public String toString() {
        return " \n User" +
                "id =" + id +
                ", name ='" + name + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", email ='" + email + '\'' +
                ", password ='" + password + '\'' +
                ", roleType =" + roleType;
    }
}
