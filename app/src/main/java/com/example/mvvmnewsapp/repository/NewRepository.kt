package com.example.mvvmnewsapp.repository

import com.example.mvvmnewsapp.database.ArticleDatabase
import com.example.mvvmnewsapp.model.Article
import com.example.mvvmnewsapp.network.RetrofitInstance

class NewRepository(val db : ArticleDatabase) {

    //get semua data untuk tampil; di breaking news
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery , pageNumber)

    //fungsi membuat databse local
    suspend fun upset(article: Article) = db.getArticleDao().upsert(article)
    // untuk menarik data yang ada di database local / bookmark
    fun getSavedNews() = db.getArticleDao().getAllArticles()
    //untuk menghapus database lokal
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}