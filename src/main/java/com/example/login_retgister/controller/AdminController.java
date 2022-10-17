package com.example.login_retgister.controller;


import com.example.login_retgister.models.Article;
import com.example.login_retgister.models.Comment;
import com.example.login_retgister.models.User;
import com.example.login_retgister.models.enums.Role;
import com.example.login_retgister.repositories.UserRepository;
import com.example.login_retgister.security.CurrentUser;
import com.example.login_retgister.serivce.ArticleService;
import com.example.login_retgister.serivce.InterestService;
import com.example.login_retgister.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final InterestService interestService;
    private final ArticleService articleService;

//    @Value("${user.image.path}")
//    private String userImagesFolder;


    @GetMapping("/home")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userHome(ModelMap modelMap,
                           @AuthenticationPrincipal UserDetails userDetails) {
        CurrentUser user = (CurrentUser) userDetails;
        modelMap.addAttribute("allUser", userRepository.findUserByRoleIs(Role.USER));
        modelMap.addAttribute("userArticle", user.getUser());
        return "admin-page";
    }
//    @GetMapping("/home")
//    public String userHome(ModelMap modelMap,
//                           @AuthenticationPrincipal UserDetails userDetails) {
//        CurrentUser currentUser = (CurrentUser) userDetails;

//        modelMap.addAttribute("allUser", userRepository.findAll());
//        modelMap.addAttribute("userArticles", articleService.articlesByAuthor(currentUser.getUser()));
//        modelMap.addAttribute("currentUser", userRepository.findByEmail(currentUser.getUser().getEmail()).get());
//        modelMap.addAttribute("article", new Article());
//        modelMap.addAttribute("interests", interestService.allInterests());
//        modelMap.addAttribute("myArticles", articleService.articlesByAuthor(currentUser.getUser()));
//        modelMap.addAttribute("comment", new Comment());
//        modelMap.addAttribute("allArticles",articleService.allArticles());
//        return "admin-page";
//
//    }

    @PostMapping("/logout")
    public String logout() {
        return "index";
    }
}

