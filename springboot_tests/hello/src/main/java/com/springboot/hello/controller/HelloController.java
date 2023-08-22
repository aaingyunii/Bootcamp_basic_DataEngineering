package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")  // @RequestMapping -> url을 매핑하여 경로를 설정, 해당 메서드 처리
    public String hello() {
        return "Hi!!";
    } // localhost 주소에서 /hello 페이지에서 확인할 수 있다.
}
    
