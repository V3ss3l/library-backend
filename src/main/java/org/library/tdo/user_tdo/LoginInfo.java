package org.library.tdo.user_tdo;

import lombok.Data;

@Data
public class LoginInfo {
    private String email;
    private String password;
    private String token;
}
