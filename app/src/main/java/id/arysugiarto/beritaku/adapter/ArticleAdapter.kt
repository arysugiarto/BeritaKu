package id.arysugiarto.beritaku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.arysugiarto.beritaku.R
import id.arysugiarto.beritaku.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter (
    private var articleList: ArrayList<Article>
): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){

    private val placeHolderImage="https://pbs.twimg.com/profile_images/467502291415617536/SP8_ylk9.png"
    private lateinit var viewGroupContext: Context

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ArticleViewHolder {
        viewGroupContext = parent.context
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent,false)
        return ArticleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article: Article = articleList.get(position)
        setPropertiesForArticleViewHolder(holder, article)
        holder.cardView.setOnClickListener{

        }

    }

    private fun setPropertiesForArticleViewHolder(articleViewHolder: ArticleViewHolder, article: Article) {
        checkForUrlToImage(article, articleViewHolder)
        articleViewHolder.title.text = article?.title
        articleViewHolder.description.text = article?.description
    }

    private fun checkForUrlToImage(article: Article, articleViewHolder: ArticleViewHolder) {
        if (article.urlToImage == null || article.urlToImage.isEmpty()) {
            Picasso.get()
                .load(placeHolderImage)
                .centerCrop()
                .fit()
                .into(articleViewHolder.urlToImage)
        } else {
            Picasso.get()
                .load(article.urlToImage)
                .centerCrop()
                .fit()
                .into(articleViewHolder.urlToImage)
        }
    }

    fun setArticles(articles: ArrayList<Article>) {
        articleList = articles
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val cardView: CardView by lazy { view.cardview }
        val urlToImage: ImageView by lazy { view.imageNews }
        val title: TextView by lazy { view.titleNews }
        val description: TextView by lazy { view.descriptionNews }
    }
}
