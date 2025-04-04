package com.common.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class UserDTO {

    private int id;
    private String username;
    protected String password;
    private String email;
    private String contact;
}
