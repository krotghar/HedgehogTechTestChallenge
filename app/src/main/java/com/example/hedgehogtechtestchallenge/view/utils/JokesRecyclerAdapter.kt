package com.example.hedgehogtechtestchallenge.view.utils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hedgehogtechtestchallenge.R
import com.example.hedgehogtechtestchallenge.data.Joke

class JokesRecyclerAdapter(private val jokes: ArrayList<Joke>) :
    RecyclerView.Adapter<JokesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        return JokesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.joke_view_holder, parent, false))
    }

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount() = jokes.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newJokes: List<Joke>) {
        jokes.clear()
        jokes.addAll(newJokes)
        notifyDataSetChanged()

    }

/*
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Joke>() {
            override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean =
                oldItem == newItem
        }
    }*/


}