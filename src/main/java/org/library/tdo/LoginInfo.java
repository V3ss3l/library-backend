package org.library.tdo;

import lombok.Data;

@Data
public class LoginInfo {
    private String email;
    private String password;
    private String token;
}
