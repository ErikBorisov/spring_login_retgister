package com.example.login_retgister.repositories;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findAllBy();

    @Query("select a from Article a where a.author=:author")
    List<Article> findAllByAuthor(@Param("author") User author);

//    @Modifying
//    @Transactional
    void deleteArticleById(int articleId);

//    @Query("delete from Article a where a.id=:articleId")
//    Article deleteArticleById(@Param("articleId")Article article);

    //    @Query("delete from Article where Article.id=:articleId")
//    Article deleteArticleById(@Param("articleId") Article article);
}
