package com.example.login_retgister.serivce.impl;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.Comment;
import com.example.login_retgister.models.User;
import com.example.login_retgister.repositories.CommentRepository;
import com.example.login_retgister.security.CurrentUser;
import com.example.login_retgister.serivce.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment, Article article, User author) {
        comment.setArticle(article);
        comment.setAuthor(author);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> commentsByArticle(final Article article) {
        return commentRepository.findAllByArticle(article);
    }

    //    @Override
//    public Comment save(final Comment comment, final Article article, final User author) {
//        comment.setAuthor(author);
//        article.setAuthor(author);
//        comment.setArticle(article);
//        return commentRepository.save(comment);
//    }
//    @Override
//    public List<Comment> commentsByArticle(Article article){
//        return commentRepository.findAllByArticle(article);
//    }

//    @Override
//    public List<Comment> commentsByAuthor(final Article article) {
//        return commentRepository.findAllByAuthor(article);
//    }

//    @Override
//    public Comment save(Comment comment, Article article) {
//        comment.setArticle(article);
//        return commentRepository.save(comment);
//    }

//    @Override
//    public Comment save(Comment comment, Article article, User author) {
//        comment.setAuthor(author);
//        article.setComments(Collections.singleton(comment));
//        return commentRepository.save(comment);
}
