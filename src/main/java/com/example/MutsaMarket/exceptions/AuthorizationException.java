package com.example.MutsaMarket.exceptions;

public class AuthorizationException extends Status403Exception{

    public AuthorizationException() {
        super("작성자와 비밀번호를 확인해주세요.");
    }
}
