package com.springboot.hello.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hello.dto.ArticleForm;
import com.springboot.hello.entity.Article;
import com.springboot.hello.service.ArticleService;


@RestController
public class ArticleApiController {
/*
 * 아래 코드는 레포지토리에서 직접 데이터를 그대로 가져온 것.
 */
    // @Autowired
    // private ArticleRepository articleRepository;

    // @GetMapping("/api/articles")
    // public List<Article> index(){ //List 형식으로 DB의 데이터를 가져온 것.
    //     return articleRepository.findAll();
    // }

    /*
     * 아래 코드는 위와 결과 값은 같지만
     * Service 라는 객체를 통해 분업하여 데이터를 받아 온 것.
     */
    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    @PostMapping("/api/articles/")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        
        // Http 응답 코드로 새로 생성 여부의 값을 삼항 연산자로 표현
        // OK : 200 , BAD_REQUEST : 400
        return (created != null) ? 
        ResponseEntity.status(HttpStatus.OK).body(created) : // OK라면, 입력한 값을 그대로 보여준다.
        ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/articles/{id}") // 기존에 있는 데이터 업데이트 하는 API
    public ResponseEntity<Article> update(@PathVariable Long id,
                                            @RequestBody ArticleForm dto){
        Article updated = articleService.update(id, dto);

        return (updated != null) ? 
        ResponseEntity.status(HttpStatus.OK).body(updated) : 
        ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        
        return (deleted != null) ? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        
        // HttpStatus.NO_CONTENT == 204
        // 204 : 요청이 성공했으나 클라이언트가 현재 페이지에서 벗어나지 않아도 된다는 것을 나타냅니다.
    }


    // 리스트로 이루어진 json 형식의 body를 통해
    // 한번에 DB에 저장할 수 있는 api
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList = articleService.createArticles(dtos);

        return (createdList != null) ? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(createdList) :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
