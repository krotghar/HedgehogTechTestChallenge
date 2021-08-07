package com.example.hedgehogtechtestchallenge.view.utils

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.hedgehogtechtestchallenge.R
import com.example.hedgehogtechtestchallenge.data.Joke

class JokesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var textJoke: TextView? = null

    init {
        textJoke = itemView.findViewById(R.id.text_joke)
    }

    fun bind(item: Joke) {
        textJoke?.text = item.joke
    }
}
