package com.stub_data_server.home;


import lombok.Builder;
import lombok.Getter;

public class AuthDto {
    @Builder
    @Getter
    public static class Response{

    }
    @Builder
    @Getter
    public static class Request{
        private String username;
        private String password;
    }
}
