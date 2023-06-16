package com.stub_data_server.helper;

import com.stub_data_server.answer.AnswerDto;
import com.stub_data_server.comment.CommentDto;
import com.stub_data_server.member.MemberDto;
import com.stub_data_server.question.QuestionDto;

import java.util.List;

public class StubData {
    public static MemberDto.Response getWriter(){
        return MemberDto.Response.builder()
                .member_id(1)
                .nickname("HongGilDong")
                .build();
    }
    public static List<AnswerDto.Response> getAnswers(){
        return List.of(
                AnswerDto.Response.builder()
                        .answer_id(1)
                        .answer_body("답변1")
                        .adopted(true)
                        .created_at(getDate())
                        .writer(getWriter())
                        .comments(getComments())
                        .build(),
                AnswerDto.Response.builder()
                        .answer_id(1)
                        .answer_body("답변1")
                        .adopted(false)
                        .created_at(getDate())
                        .writer(getWriter())
                        .comments(List.of())
                        .build()
        );
    }

    public static List<QuestionDto.MultiResponse> getQuestions(){
        return List.of(
                QuestionDto.MultiResponse.builder()
                        .question_id(4)
                        .title("네번째 질문 글 제목")
                        .created_at(getDate())
                        .adopted(false)
                        .comments_number(2)
                        .writer(getWriter())
                        .views(0)
                        .build(),
                QuestionDto.MultiResponse.builder()
                        .question_id(3)
                        .title("세번째 질문 글 제목")
                        .created_at(getDate())
                        .adopted(true)
                        .comments_number(3)
                        .writer(getWriter())
                        .views(1)
                        .build(),
                QuestionDto.MultiResponse.builder()
                        .question_id(2)
                        .title("두번째 질문 글 제목")
                        .created_at(getDate())
                        .adopted(false)
                        .comments_number(3)
                        .writer(getWriter())
                        .views(3)
                        .build(),
                QuestionDto.MultiResponse.builder()
                      .question_id(1)
                      .title("첫번째 질문 글 제목")
                      .created_at(getDate())
                      .adopted(false)
                      .comments_number(1)
                      .writer(getWriter())
                        .views(5)
                      .build()
        );
    }

    public static List<CommentDto.Response> getComments(){
        return List.of(
                CommentDto.Response.builder()
                        .answer_id(1)
                        .comment_id(1)
                        .comment_body("댓글1")
                        .created_at(getDate())
                        .writer(getWriter())
                        .build(),
                CommentDto.Response.builder()
                        .answer_id(1)
                        .comment_id(2)
                        .comment_body("댓글2")
                        .created_at(getDate())
                        .writer(getWriter())
                        .build()
        );
    }

    public static String getDate(){
        return "2023-00-00T00:00:00.000000";
    }
}
