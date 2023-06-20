package com.stub_data_server.comment;


import com.stub_data_server.member.MemberDto;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class CommentDto {
    @Builder
    @Getter
    public static class Response{
        private long answerId;
        private long commentId;
        private String commentBody;
        private String createdAt;
        private MemberDto.Response writer;
    }



    @Builder
    @Getter
    public static class Request{
        private long commentId;
        private String commentBody;
    }
}
