package com.example.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class User {
    private Long userId;
    private String userName;
    private String passWord;
    private String role;
    private String grade;
}
