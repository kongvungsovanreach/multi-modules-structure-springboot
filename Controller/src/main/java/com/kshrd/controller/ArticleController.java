package com.kshrd.controller;

import com.kshrd.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    @ResponseBody
    public List index(){
       return articleService.printNow();
    }
}
