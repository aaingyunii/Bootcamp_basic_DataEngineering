package com.springboot.hello.dto;

import com.springboot.hello.entity.Article;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title; // 제목
    private String content; // 내용

    public Article toEntity(){
        return new Article(id, title, content);
    }
    // public ArticleFrom(String title, String content){
    //     this.title = title;
    //     this.content = content;
    // }
}
