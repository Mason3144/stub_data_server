package com.stub_data_server.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postMember(@RequestBody MemberDto.Request requestBody){
        MemberDto.Response member = MemberDto.Response.builder()
                .memberId(1)
                .nickname(requestBody.getNickname())
                .build();
        log.info("회원 가입 완료");
        return new ResponseEntity(member, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId){
        MemberDto.Response member = MemberDto.Response.builder()
                .memberId(memberId)
                .nickname("hgd123")
                .build();
        log.info("회원 조회 완료");
        return new ResponseEntity(member, HttpStatus.OK);
    }
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId){
        log.info("회원 탈퇴 완료");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                      @RequestBody MemberDto.Request requestBody){
        MemberDto.Response member = MemberDto.Response.builder()
                .memberId(memberId)
                .nickname(requestBody.getNickname()==null?"hgd123":requestBody.getNickname())
                .build();

        log.info("회원 정보 수정 완료");
        return new ResponseEntity(member, HttpStatus.OK);
    }
}
