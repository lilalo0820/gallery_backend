package com.sprbt.backend.controller;

import com.sprbt.backend.entity.Member;
import com.sprbt.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/api/member/login")
    public int login(@RequestBody Map<String,String> params){
        Member member = memberRepository.findByEmailAndPassword(params.get("email"),params.get("password"));


        int result = 0;
        if(member != null){
            result = member.getId();
        }

        return  result;
    }

}
