package com.api.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
    return "Hi Enore!!";
    }
    
    
    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member") // 사용자로부터 바디, 입력을 받아 POST 요청을 한다.
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }


    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
    */
    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2") // 바디에 MemberDto 형식에 맞춰 내용 전달.
    public String postMemberDto(@RequestBody MemberDto memberDTO) {
        return memberDTO.toString();
    }

    @PostMapping(value = "/member3") // 바디에 MemberDto 형식에 맞춰 내용 전달.
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDTO) {
        return memberDTO;
    }

}
