package com.belhard.bookstoreBoot.web.exeption;

import javax.security.auth.login.AccountNotFoundException;

public class AppException extends AccountNotFoundException {
    public AppException(String message) {
        super(message);
    }
}
