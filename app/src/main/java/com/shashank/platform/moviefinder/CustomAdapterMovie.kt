package com.shashank.platform.moviefinder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.shashank.platform.moviefinder.R

class CustomAdapterMovie(private val searchResultsList: MutableList<SearchResults.SearchItem>) :
    RecyclerView.Adapter<CustomAdapterMovie.MyViewHolder>() {

    private val ITEM = 0
    private val LOADING = 1
    private var isLoadingAdded = false
    internal lateinit var context: Context

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var title: TextView? = null
        internal var year: TextView? = null
        internal var poster: ImageView? = null

        init {
            title = view.findViewById(R.id.title)
            year = view.findViewById(R.id.year)
            poster = view.findViewById(R.id.poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView: View? = null
        when (viewType) {
            ITEM -> itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie, parent, false)
            LOADING -> itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_progress, parent, false)
        }
        context = parent.context
        return MyViewHolder(itemView!!)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val searchResults = searchResultsList[position]
        when (getItemViewType(position)) {
            ITEM -> {
                holder.title?.setText(searchResults.title)
                holder.year?.setText(searchResults.year)
                Glide.with(context).load(searchResults.poster)
                    .asBitmap().centerCrop()
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.ic_launcher_background)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.poster)
            }
        }

    }

    override fun getItemCount(): Int {
        return if (searchResultsList == null) 0 else searchResultsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == searchResultsList.size - 1 && isLoadingAdded) LOADING else ITEM
    }


    /*
   Helpers
   _________________________________________________________________________________________________
    */

    fun add(r: SearchResults.SearchItem) {
        searchResultsList.add(r)
        notifyItemInserted(searchResultsList.size - 1)
    }

    fun addAll(moveResults: List<SearchResults.SearchItem>) {
        for (result in moveResults) {
            add(result)
        }
    }

    fun remove(r: SearchResults.SearchItem?) {
        val position = searchResultsList.indexOf(r)
        if (position > -1) {
            searchResultsList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun clear() {
        isLoadingAdded = false
        while (itemCount > 0) {
            remove(getItem(0))
        }
    }

    fun isEmpty(): Boolean {
        return itemCount == 0
    }


    fun addLoadingFooter() {
        isLoadingAdded = true
        add(SearchResults.SearchItem())
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false

        val position = searchResultsList.size - 1
        val result = getItem(position)

        if (result != null) {
            searchResultsList.removeAt(position)
            notifyItemRemoved(position)
        }
    }


    fun getItem(position: Int): SearchResults.SearchItem? {
        return searchResultsList[position]
    }

}