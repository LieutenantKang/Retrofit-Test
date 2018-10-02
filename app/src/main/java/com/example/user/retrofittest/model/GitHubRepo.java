package com.example.user.retrofittest.model;

/* Model: 서버와 데이터 교환시 사용하는 데이터 객체 */
public class GitHubRepo {
    private String name;

    public GitHubRepo (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}