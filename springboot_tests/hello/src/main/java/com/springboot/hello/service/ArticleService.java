package com.springboot.hello.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.hello.dto.ArticleForm;
import com.springboot.hello.entity.Article;
import com.springboot.hello.repository.ArticleRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index(){
        return articleRepository.findAll();
    }

    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto){
        Article article = dto.toEntity();
        
        // create 함수는 새로운 값을 만드는 것이기 때문에
        // 입력 받은 객체의 id값이 이미 존재한다면 == article.getId() != null
        // null 값을 던져 새로 생성하지 못하도록 한다.
        if(article.getId() != null){
            return null;
        }else{
            return articleRepository.save(article);
        }
    }

    public Article update(Long id, ArticleForm dto){
        Article article = dto.toEntity();

        // 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null || id != article.getId()){
            return null;
        }

        // 정상일 때
        target.patch(article);
        Article updated = articleRepository.save(target);

        return updated;
    }

    public Article delete(Long id){
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null){
            return null;
        }

        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos){
        List<Article> articleList = dtos
                                        .stream()
                                        .map(dto -> dto.toEntity())
                                        .collect(Collectors.toList());
        
        // DB에 저장
        articleList.stream()
                    .forEach(article -> articleRepository.save(article));
        
        // 일부러 에러를 발생시킨 경우 (id가 -1)
        // 이 함수가 Transactional 이기 때문에
        // 리스트의 하나만 잘못되어도 전체가 거절된다. 
        // articleRepository.findById(-1L)
        //                 .orElseThrow(()-> new IllegalArgumentException("실패"));
        
        return articleList;
    }
}
