package com.disney.alkemy.auth.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data

public class UserDTO {

    @Email(message = "El nombre de usuario tiene que ser su E-mail")
    private String username;
    @Size(min = 8)
    private String password;

}
