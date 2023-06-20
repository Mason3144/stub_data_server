package com.stub_data_server.helper;

import com.stub_data_server.answer.AnswerDto;
import com.stub_data_server.comment.CommentDto;
import com.stub_data_server.member.MemberDto;
import com.stub_data_server.question.QuestionDto;

import java.util.List;

public class StubData {
    public static MemberDto.Response getWriter(){
        return MemberDto.Response.builder()
                .memberId(1)
                .nickname("HongGilDong")
                .build();
    }
    public static List<AnswerDto.Response> getAnswers(){
        return List.of(
                AnswerDto.Response.builder()
                        .answerId(1)
                        .answerBody("답변1")
                        .adopted(true)
                        .createdAt(getDate())
                        .writer(getWriter())
                        .comments(getComments())
                        .build(),
                AnswerDto.Response.builder()
                        .answerId(1)
                        .answerBody("답변1")
                        .adopted(false)
                        .createdAt(getDate())
                        .writer(getWriter())
                        .comments(List.of())
                        .build()
        );
    }

    public static List<QuestionDto.MultiResponse> getQuestions(){
        return List.of(
                QuestionDto.MultiResponse.builder()
                        .questionId(4)
                        .title("네번째 질문 글 제목")
                        .createdAt(getDate())
                        .adopted(false)
                        .commentsNumber(2)
                        .writer(getWriter())
                        .views(0)
                        .build(),
                QuestionDto.MultiResponse.builder()
                        .questionId(3)
                        .title("세번째 질문 글 제목")
                        .createdAt(getDate())
                        .adopted(true)
                        .commentsNumber(3)
                        .writer(getWriter())
                        .views(1)
                        .build(),
                QuestionDto.MultiResponse.builder()
                        .questionId(2)
                        .title("두번째 질문 글 제목")
                        .createdAt(getDate())
                        .adopted(false)
                        .commentsNumber(3)
                        .writer(getWriter())
                        .views(3)
                        .build(),
                QuestionDto.MultiResponse.builder()
                      .questionId(1)
                      .title("첫번째 질문 글 제목")
                      .createdAt(getDate())
                      .adopted(false)
                      .commentsNumber(1)
                      .writer(getWriter())
                        .views(5)
                      .build()
        );
    }

    public static List<CommentDto.Response> getComments(){
        return List.of(
                CommentDto.Response.builder()
                        .answerId(1)
                        .commentId(1)
                        .commentBody("댓글1")
                        .createdAt(getDate())
                        .writer(getWriter())
                        .build(),
                CommentDto.Response.builder()
                        .answerId(1)
                        .commentId(2)
                        .commentBody("댓글2")
                        .createdAt(getDate())
                        .writer(getWriter())
                        .build()
        );
    }

    public static String getDate(){
        return "2023-00-00T00:00:00.000000";
    }
}
