package com.lecture.spring.springbootclass;

import com.lecture.spring.springbootclass.repository.JpaMemberRepository;
import com.lecture.spring.springbootclass.repository.MemberRepository;
import com.lecture.spring.springbootclass.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // JPA 이외 사용시
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    // JPA 사용시
//    @PersistenceContext
//    private EntityManager em;
//
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    // spring data JPA 사용시
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // spring data JPA 이외 사용
//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
//
//        // 메모리에서 Jdbc로 바꾸기 (실행 코드를 변경하지 않고 구현체을 바꾸기)
////        return new JdbcMemberRepository(dataSource);
//
//        // JdbcTemplate 사용
////        return new JdbcTemplateMemberRepository(dataSource);
//
//        // JPA 사용
//        return new JpaMemberRepository(em);
//    }
}
