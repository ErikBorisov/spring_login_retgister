package com.example.login_retgister.controller.articleController;

import com.example.login_retgister.models.Article;
import com.example.login_retgister.serivce.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/delete")
@Log4j2
public class ArticleDeleteController {

    private final ArticleService articleService;


    @PostMapping
    public String deleteArticle(@RequestParam(name = "articleId") int articleId) {
//        Article delete = articleService.delete(Article.builder().id(articleId).build());
        articleService.delete(Article.builder().id(articleId).build());
        log.info("Saving new article {}");
        return "redirect:/user/home";
    }
}
//    @DeleteMapping("/deleteOrder/{orderId}")
//    public Boolean deleteOrder(@PathVariable(value = "id") Long orderId) {
//        // Access the DB and delete the order
//        return true;
//    }
