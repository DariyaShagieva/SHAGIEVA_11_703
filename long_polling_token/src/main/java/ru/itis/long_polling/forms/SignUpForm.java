package ru.itis.long_polling.forms;

import lombok.Data;

@Data
public class SignUpForm {
    private String login;
    private String password;
}
