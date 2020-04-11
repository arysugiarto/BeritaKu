package id.arysugiarto.beritaku.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import id.arysugiarto.beritaku.R
import id.arysugiarto.beritaku.adapter.ArticleAdapter
import id.arysugiarto.beritaku.api.TopHeadlinesEndpoint
import id.arysugiarto.beritaku.model.Article
import id.arysugiarto.beritaku.model.TopHeadlines
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private val ENPOINT_URL by lazy { "https://newsapi.org/v2/" }
    private lateinit var topHeadlinesEndpoint: TopHeadlinesEndpoint
    private lateinit var newsApiConfig: String
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articleList: ArrayList<Article>
    private lateinit var userKeywordInput: String

//    rx
    private lateinit var topHeadlinesObservable: Observable <TopHeadlines>
    private lateinit var compositeDisposable: CompositeDisposable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    override fun onRefresh() {
        TODO("not implemented yet") // Will be implemented at the end
    }
}
