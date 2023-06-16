package com.stub_data_server.home;

import com.stub_data_server.helper.StubData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
@CrossOrigin
public class HomeController {
    @GetMapping("/home")
    public ResponseEntity getLoggedOutHome(){
        log.info("Not Logged in home");
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getLoggedInHome(){
        HomeDto.Response response = HomeDto.Response.builder()
                .member(StubData.getWriter())
                .data(StubData.getQuestions())
                .build();
        log.info("Logged in home");
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity postLogin(@RequestBody AuthDto.Request requestBody){
        log.info("로그인 완료");
        return new ResponseEntity(StubData.getWriter(),HttpStatus.OK);
    }
    @GetMapping("oauth2/authorization/google")
    public ResponseEntity getSocialLogin(){
        log.info("로그인 완료");
        return new ResponseEntity(StubData.getWriter(),HttpStatus.OK);
    }
}
