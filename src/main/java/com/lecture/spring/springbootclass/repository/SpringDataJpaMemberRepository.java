package com.lecture.spring.springbootclass.repository;

import com.lecture.spring.springbootclass.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // ?????? 구현을 안했는데....? 엄청난 기술....

    @Override
    Optional<Member> findByName(String name);
}
