package com.example.demo.controller;

import com.example.demo.Repository.ArticleRepository;
import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        //System.out.println(form.toString());
        // 1. DTO -> entity
        log.info(form.toString());
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());
        // 2. repository로 entity를 DB에 저장
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);
        // 1. id를 조회해서 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //log.info("articleEntity : " + articleEntity.toString());
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList",articleEntityList);
        // 3. 뷰 페이지 설정
        return "articles/index";
    }
}