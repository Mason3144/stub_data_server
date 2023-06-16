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
        private long question_id;
        private String title;
        private String body;
        private String created_at;
        private MemberDto.Response writer;
        private List<AnswerDto.Response> answers;
    }
    @Builder
    @Getter
    public static class MultiResponse{
        private long question_id;
        private String title;
        private String created_at;
        private boolean adopted;
        private MemberDto.Response writer;
        private int comments_number;
        private int views;
    }
    @Builder
    @Getter
    public static class Request{
        private String title;
        private String body;
    }
}