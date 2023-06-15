package com.stub_data_server.comment;


import com.stub_data_server.member.MemberDto;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class CommentDto {
    @Builder
    @Getter
    public static class Response{
        private long answer_id;
        private long comment_id;
        private String comment_body;
        private String created_at;
        private MemberDto.Response writer;
    }



    @Builder
    @Getter
    public static class Request{
        private long comment_id;
        private String comment_body;
    }
}
