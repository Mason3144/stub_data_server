package com.stub_data_server.answer;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.stub_data_server.comment.CommentDto;
import com.stub_data_server.member.MemberDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;


public class AnswerDto {

    @Builder
    @Getter
    public static class Response{
        private long answerId;
        private String answerBody;
        private boolean adopted;
        private String createdAt;
        private MemberDto.Response writer;
        private List<CommentDto.Response> comments;
    }

    @Builder
    @Getter
    public static class Request{
        private long answerId;
        private String answerBody;
    }
}
