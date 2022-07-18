package com.lecture.spring.springbootclass.domain;

import jdk.jfr.Name;

import javax.persistence.*;

// JPA를 사용하기 위한 어노테이션
@Entity
public class Member {

    // DB와 매핑하기 위한 어노테이션 (strategy 기본키 DB에서 자동 부여 옵션)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 만약 DB의 name의 컬럼명이 다르다면 밑처럼 설정
//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
