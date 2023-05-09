package com.belhard.bookstoreBoot.web.exeption;

public class BadRequestException extends RuntimeException{
    public BadRequestException (String message) {
        super(message);
    }
}
