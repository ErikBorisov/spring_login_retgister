package com.example.login_retgister.repositories;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.Comment;
import com.example.login_retgister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c where c.article=:article")
    List<Comment> findAllByArticle(@Param("article") Article article);

    //    @Override
//    List<Comment> findAll();

    //    @Query("select c from Comment c where c.article=:article")
//    List<Comment> findAllByAuthor(@Param("article") Article article);

}
