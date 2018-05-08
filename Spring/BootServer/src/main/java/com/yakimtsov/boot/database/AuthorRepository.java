package com.yakimtsov.boot.database;

import com.yakimtsov.boot.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Article, Long> {
}
