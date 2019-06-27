package com.kshrd.service;

import com.kshrd.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public List printNow(){
        return articleRepository.findAll();
    }
}
