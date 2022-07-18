package com.lecture.spring.springbootclass.service;

import com.lecture.spring.springbootclass.domain.Member;
import com.lecture.spring.springbootclass.repository.JdbcMemberRepository;
import com.lecture.spring.springbootclass.repository.MemberRepository;
import com.lecture.spring.springbootclass.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 통합 테스트

// 스프링 컨테이너와 함께 테스트를 진행한다는 어노테이션
@SpringBootTest
// 테스트에 Transactional이 붙으면 테스트 시작전에 트랜젝션이 시작하고 테스트가 끝난후 롤백한다.
@Transactional
class MemberServiceIntegrationTest {
    // 테스트이기 때문에 필드 주입을 사용
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("boot");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원차단() {
        //given
        Member member1 = new Member();
        member1.setName("boot1");
        Member member2 = new Member();
        member2.setName("boot1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}