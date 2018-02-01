package com.loncoto.loncontoBoot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.loncoto.loncontoBoot.metier.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

}
