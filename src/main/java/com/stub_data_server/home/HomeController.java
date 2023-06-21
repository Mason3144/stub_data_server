package com.stub_data_server.home;

import com.stub_data_server.helper.StubData;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpClient;

@Slf4j
@RestController
@RequestMapping
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
    public void getSocialLogin(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        log.info("로그인 완료");
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("access_token","Bearer eyJhbGciOiJIUzM4NCJ9.eyJyb2xlcyI6WyJVU0VSIl0sIm5pY2tuYW1lIjoiYW5qZHNuYWpzZCIsInVzZXJuYW1lIjoiYXNkQGFzZC5hc2QiLCJtZW1iZXJJZCI6MSwic3ViIjoiYXNkQGFzZC5hc2QiLCJpYXQiOjE2ODczMjMyOTgsImV4cCI6MTY4NzMyNTA5OH0.xX88bQwcjgb-o4na6BXrHi2Kxs79oFsIkkXZzGqESO4-BtFcz0x0tNaQSjOIa0oy");
        queryParams.add("refresh_token","eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhc2RAYXNkLmFzZCIsImlhdCI6MTY4NzMyMzI5OCwiZXhwIjoxNjg3MzQ4NDk4fQ.3MgxHyWVbqLAov_TqRQW5OpvyfEX6a5oM7znWz1SHSc-J0UGzdU86tP0cZ5Uh_67");
        queryParams.add("memberId","1");
        queryParams.add("nickname","hgd123");

        String uri = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("localhost")
                .port(3000)
                .path("/oauth2/authorization/google/success")
                .queryParams(queryParams)
                .build()
                .toString();

        response.sendRedirect(uri);
    }
}
