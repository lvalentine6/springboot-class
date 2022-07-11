package com.lecture.spring.springbootclass;

import com.lecture.spring.springbootclass.repository.MemberRepository;
import com.lecture.spring.springbootclass.repository.MemoryMemberRepository;
import com.lecture.spring.springbootclass.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
