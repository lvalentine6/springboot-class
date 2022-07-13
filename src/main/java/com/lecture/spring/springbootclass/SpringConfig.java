package com.lecture.spring.springbootclass;

import com.lecture.spring.springbootclass.repository.JdbcMemberRepository;
import com.lecture.spring.springbootclass.repository.MemberRepository;
import com.lecture.spring.springbootclass.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        // 메모리에서 Jdbc로 바꾸기 (실행 코드를 변경하지 않고 구현체을 바꾸기)
        return new JdbcMemberRepository(dataSource);
    }
}
