package com.kshrd.repository;

import com.kshrd.model.Article;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {

    @Select("SELECT * FROM tb_articles")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "category.id", column = "category_id"),
            @Result(property = "category.titrle", column = "category_title"),
            @Result(property = "author", column = "author"),
            @Result(property = "description", column = "description"),
            @Result(property = "thumbnail", column = "thumbnail")
    })
    List<Article> findAll();
}
