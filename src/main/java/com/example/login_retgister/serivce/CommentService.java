package com.example.login_retgister.serivce;

import com.example.login_retgister.models.Comment;
import com.example.login_retgister.models.User;

public interface CommentService {

    Comment save(Comment comment, User author);

}