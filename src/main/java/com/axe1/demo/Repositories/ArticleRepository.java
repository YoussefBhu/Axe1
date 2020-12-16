package com.axe1.demo.Repositories;

import com.axe1.demo.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
