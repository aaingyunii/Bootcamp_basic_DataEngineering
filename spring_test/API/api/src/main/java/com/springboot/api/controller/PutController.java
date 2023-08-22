package com.springboot.api.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

import java.util.Map;



@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + "  : "+ map.getValue()+ "\n");
        });
        return sb.toString();
    }


    @PutMapping(value="/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping(value="/member2") //MemberDto 객체를 반환값으로 가지기 때문에 
                                // 해당 객체안에 오버라이딩된 toString() 함수로 반환된다.
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }
}
