package com.example.login_retgister.serivce;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.Comment;
import com.example.login_retgister.models.User;
import com.example.login_retgister.security.CurrentUser;

import java.util.Currency;
import java.util.List;

public interface CommentService {
    Comment save(Comment comment, Article article, User author);

    List<Comment> commentsByArticle(Article article);
}
