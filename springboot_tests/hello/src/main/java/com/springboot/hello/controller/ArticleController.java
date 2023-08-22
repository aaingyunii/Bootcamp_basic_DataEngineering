package com.springboot.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.hello.dto.ArticleForm;
import com.springboot.hello.entity.Article;
import com.springboot.hello.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newAriticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        // System.out.println(saved.toString());
        log.info(saved.toString());
        // return "articles/create";

        // redirect 를 통해 동작 수행 완료 후
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+id);
        // id를 통해 데이터 조회

        Article articleEntity = articleRepository.findById(id).orElse(null);
        // id값으로 데이터를 찾음 -> id가 없으면 null 리턴
        // id값이 있으면 articleEntity 변수에 값을 리턴

        // model에 데이터 등록
        model.addAttribute("articles", articleEntity);

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든 데이터 가져오기
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("articleList", articleEntityList);
        
        // 3. 뷰에 전송
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        // show 함수와 똑같이 가져온다.
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("articles", articleEntity);

        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        Article article = form.toEntity();
        log.info(article.toString());
        Article target  = articleRepository.findById(article.getId()).orElse(null);
        
        if(target != null){
            articleRepository.save(article);
        }
        return "redirect:/articles/" + article.getId();
    }
    
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        Article target = articleRepository.findById(id).orElse(null);
        
        if(target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제완료!");
        }
        return "redirect:/articles/";
    }
}
