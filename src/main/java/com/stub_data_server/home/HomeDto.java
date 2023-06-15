package com.stub_data_server.home;

import com.stub_data_server.member.MemberDto;
import com.stub_data_server.question.QuestionDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


public class HomeDto {
    @Getter
    @Builder
    public static class Response{
        MemberDto.Response member;
        List<QuestionDto.MultiResponse> data;
    }
}
