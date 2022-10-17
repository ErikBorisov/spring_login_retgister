package com.example.login_retgister.serivce.impl;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.User;
import com.example.login_retgister.repositories.ArticleRepository;
import com.example.login_retgister.serivce.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleServiceImpl implements ArticleService {


    private final ArticleRepository articleRepository;


    @Override
    public Article save(final Article article, final User author) {
        article.setAuthor(author);
        return articleRepository.save(article);
    }

    @Override
    public List<Article> allArticles() {
        return articleRepository.findAllBy();
    }


    @Override
    public List<Article> articlesByAuthor(final User user) {
        return articleRepository.findAllByAuthor(user);
    }

    @Override
    public void delete(Article article) {
        articleRepository.deleteArticleById(article.getId());
    }

//    @Override
//    public Article delete(int articleId) {
//        return articleRepository.deleteArticleById(articleId);
//    }

}
