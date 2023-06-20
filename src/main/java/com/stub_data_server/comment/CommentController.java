package com.stub_data_server.answer;

import com.stub_data_server.comment.CommentDto;
import com.stub_data_server.helper.StubData;
import com.stub_data_server.member.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@Slf4j
@RestController
@RequestMapping("/question/{question-id}/answers/{answer-id}/comments")
@CrossOrigin
public class CommentController {
    @PostMapping
    public ResponseEntity postComment(@PathVariable("question-id")  long questionId,
                                      @PathVariable("answer-id")  long answerId,
                                     @RequestBody CommentDto.Request requestBody){

        CommentDto.Response response = CommentDto.Response.builder()
                .answerId(answerId)
                .commentId(1)
                .commentBody(requestBody.getCommentBody())
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .build();
        log.info("댓글 생성 완료");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{comment-id}")
    public ResponseEntity patchAnswer(@PathVariable("question-id")  long questionId,
                                      @PathVariable("answer-id")  long answerId,
                                      @PathVariable("comment-id")  long commentId,
                                      @RequestBody CommentDto.Request requestBody){

        CommentDto.Response response = CommentDto.Response.builder()
                .answerId(answerId)
                .commentId(commentId)
                .commentBody(requestBody.getCommentBody())
                .createdAt(StubData.getDate())
                .writer(StubData.getWriter())
                .build();
        log.info("댓글 수정 완료");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteAnswer(@PathVariable("question-id")  long questionId,
                                       @PathVariable("answer-id")  long answerId){
        log.info("댓글 삭제 완료");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
