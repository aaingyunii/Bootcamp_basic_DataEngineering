package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "hello encore!!";
    }

    @GetMapping(value="/name")
    public String getName(){
        return "haha";
    }

    @GetMapping(value="/variable1/{variable}") // 주소값을 매개변수로 설정하는 방법. {} /variable1/ 은 매개변수 설정과 관련없음.
    public String getVaString(@PathVariable String variable){ // 매개변수는 GetMapping의 {}안의 매개 변수와 똑같아야한다.
        return variable;
    }

    @GetMapping(value="/variable2/{var}") // 주소값을 매개변수로 설정하는 방법. {} /variable1/ 은 매개변수 설정과 관련없음.
    public String getVar(@PathVariable String var){ // 매개변수는 GetMapping의 {}안의 매개 변수와 똑같아야한다.
        return var;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(
        @RequestParam String name, // 해당 주소를 불러오는 방법은
        @RequestParam String email, // request1?name=name&email=email&organization=organ...
        @RequestParam String organization){
            return name + " " + email + " " + organization;
        }


    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        }); // getRequestParam1 처럼 키값이 명시되지 않고, 입력된 방식대로 키-값이 그대로 입력된다.
            // '=' 이 없고 & 이어지면 그전에 입력된값은 키로만 인식되고 그대로 수행.

        return sb.toString();
    }

	@GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
