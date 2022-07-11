package com.lecture.spring.springbootclass.controller;


// CreateForm에서 넘어오는 데이터를 제어하는 컨트롤러
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
