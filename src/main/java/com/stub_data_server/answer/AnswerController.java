package com.stub_data_server.answer;

import com.stub_data_server.helper.StubData;
import com.stub_data_server.member.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question/{question-id}/answers")
@CrossOrigin
public class AnswerController {
    @PostMapping
    public ResponseEntity postAnswer(@PathVariable("question-id") long questionId,
                                     @RequestBody AnswerDto.Request requestBody){
                AnswerDto.Response response = AnswerDto.Response.builder()
                .answerId(1)
                .adopted(false)
                .answerBody(requestBody.getAnswerBody())
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .comments(List.of())
                .build();
        log.info("답변 생성 완료");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{answer-id}/edit")
    public ResponseEntity patchAnswer(@PathVariable("question-id")  long questionId,
                                      @PathVariable("answer-id")  long answerId,
                                     @RequestBody AnswerDto.Request requestBody){
        AnswerDto.Response response = AnswerDto.Response.builder()
                .answerId(answerId)
                .adopted(false)
                .answerBody(requestBody.getAnswerBody())
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .comments(List.of())
                .build();
        log.info("답변 수정 완료");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{answer-id}")
    public ResponseEntity deleteAnswer(@PathVariable("question-id")  long questionId,
                                      @PathVariable("answer-id")  long answerId){
        log.info("답변 삭제 완료");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{answer-id}/adopt")
    public ResponseEntity postAdoptAnswer(@PathVariable("question-id")  long questionId,
                                      @PathVariable("answer-id")  long answerId){

        AnswerDto.Response response = AnswerDto.Response.builder()
                .answerId(answerId)
                .adopted(true)
                .answerBody("답변 내용")
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .comments(List.of())
                .build();
        log.info("답변 채택 완료");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/{answer-id}/adopt")
    public ResponseEntity deleteAdoptAnswer(@PathVariable("question-id")  long questionId,
                                      @PathVariable("answer-id")  long answerId){

        AnswerDto.Response response = AnswerDto.Response.builder()
                .answerId(answerId)
                .adopted(false)
                .answerBody("답변 내용")
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .comments(List.of())
                .build();
        log.info("답변 채택 취소");
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
