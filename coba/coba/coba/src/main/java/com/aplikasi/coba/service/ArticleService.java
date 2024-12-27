package com.aplikasi.coba.service;

import com.aplikasi.coba.model.Article;
import com.aplikasi.coba.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id); // Mengambil artikel berdasarkan ID
    }
}
