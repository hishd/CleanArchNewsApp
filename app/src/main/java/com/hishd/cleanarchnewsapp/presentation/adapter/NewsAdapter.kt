package com.hishd.cleanarchnewsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hishd.cleanarchnewsapp.data.model.Article
import com.hishd.cleanarchnewsapp.databinding.ItemNewsListBinding
import com.hishd.cleanarchnewsapp.presentation.util.DateFormatter

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val binding = ItemNewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bindView(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

//    fun setArticleData(newsArticles: List<Article>) {
//        this.newsArticles.clear()
//        this.newsArticles.addAll(newsArticles)
//        this.notifyDataSetChanged()
//    }

    inner class NewsAdapterViewHolder(private val binding: ItemNewsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(newsArticle: Article) {
            binding.txtTitle.text = newsArticle.title
            binding.txtDate.text = "Published At : ${newsArticle.publishedAt}"
            binding.txtSource.text = "Source : ${newsArticle.source.name}"
            binding.txtDescription.text = newsArticle.description
            Glide.with(binding.imgPoster.context).load(newsArticle.urlToImage).into(binding.imgPoster)
        }
    }
}