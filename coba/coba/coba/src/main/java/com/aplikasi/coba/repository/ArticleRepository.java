package com.aplikasi.coba.repository;

import com.aplikasi.coba.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Fungsi ini tidak perlu ditulis karena JpaRepository sudah menyediakan fungsi standar seperti findById
}
