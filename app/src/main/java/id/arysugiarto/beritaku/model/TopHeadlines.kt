package id.arysugiarto.beritaku.model

import id.arysugiarto.beritaku.model.Article

data class TopHeadlines(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)