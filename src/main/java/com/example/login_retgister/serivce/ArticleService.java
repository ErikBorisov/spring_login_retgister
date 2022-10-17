package com.example.login_retgister.serivce;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.User;

import java.util.List;

public interface ArticleService {

    Article save(Article article, User author);

//    Article delete(User author);

//    Article delete(Article article, User author);

    List<Article> allArticles();

    List<Article> articlesByAuthor(User user);

    void delete(Article articleId);


//    Article delete(int articleId);
}
