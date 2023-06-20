package com.stub_data_server.question;

import com.stub_data_server.helper.MultiResponseDto;
import com.stub_data_server.helper.PageInfo;
import com.stub_data_server.helper.StubData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/questions")
@CrossOrigin
public class QuestionController {
    @PostMapping("ask")
    public ResponseEntity postQuestion(@RequestBody QuestionDto.Request requestBody){

        QuestionDto.Response response = QuestionDto.Response.builder()
                .questionId(1)
                .title(requestBody.getTitle())
                .body(requestBody.getBody())
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .answers(List.of())
                .build();
        log.info("질문글 등록 완료");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}/edit")
    public ResponseEntity patchQuestion(@PathVariable("question-id") long questionId,
                                        @RequestBody QuestionDto.Request requestBody){

        QuestionDto.Response response = QuestionDto.Response.builder()
                .questionId(questionId)
                .title(requestBody.getTitle())
                .body(requestBody.getBody())
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .answers(List.of())
                .build();
        log.info("질문글 수정 완료");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") long questionId){
        log.info("질문글 삭제 완료");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") long questionId){
        QuestionDto.Response response = QuestionDto.Response.builder()
                .questionId(questionId)
                .title("질문 제목")
                .body("질문 본문 20자 이상")
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .answers(StubData.getAnswers())
                .build();
        log.info("질문글 상세 조회 완료");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/board")
    public ResponseEntity getQuestions(@RequestParam int page,
                                       @RequestParam int size,
                                       @RequestParam String sort){
        PageInfo pageInfo = PageInfo.builder()
                .page(page)
                .size(size)
                .totalElements(4)
                .totalPages(1)
                .build();
        log.info("게시판 조회 완료");
        return new ResponseEntity(new MultiResponseDto(StubData.getQuestions(),pageInfo), HttpStatus.OK);
    }
    @GetMapping("/home")
    public ResponseEntity getQuestionsHome(){

        log.info("게시판 조회 완료");
        return new ResponseEntity(new MultiResponseDto(StubData.getQuestions(),null), HttpStatus.OK);
    }
}
