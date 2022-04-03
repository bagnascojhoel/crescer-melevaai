package br.com.cwi.crescer.melevaai.security;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private String email;

    private String firstName;

    private String lastName;

    private List<String> roles;

}
