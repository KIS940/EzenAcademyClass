package org.example.springBootDeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springBootDeveloper.domain.Article;
import org.example.springBootDeveloper.dto.AddArticleRequest;
import org.example.springBootDeveloper.dto.UpdateArticleRequest;
import org.example.springBootDeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }
}