package com.stub_data_server.question;


import com.stub_data_server.answer.AnswerDto;
import com.stub_data_server.member.MemberDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class QuestionDto {
    @Builder
    @Getter
    public static class Response{
        private long questionId;
        private String title;
        private String body;
        private String createdAt;
        private MemberDto.Response writer;
        private List<AnswerDto.Response> answers;
    }
    @Builder
    @Getter
    public static class MultiResponse{
        private long questionId;
        private String title;
        private String createdAt;
        private boolean adopted;
        private MemberDto.Response writer;
        private int commentsNumber;
        private int views;
    }
    @Builder
    @Getter
    public static class Request{
        private String title;
        private String body;
    }
}