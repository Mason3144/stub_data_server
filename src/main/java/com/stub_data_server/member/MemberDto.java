package com.stub_data_server.member;


import lombok.Builder;
import lombok.Getter;


public class MemberDto {
    @Builder
    @Getter
    public static class Response{
        private long member_id;
        private String nickname;
    }
    @Builder
    @Getter
    public static class Request{
        private String email;
        private String password;
        private String nickname;
    }

}
