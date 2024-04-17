package org.example.springBootDeveloper.repository;

import org.example.springBootDeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
