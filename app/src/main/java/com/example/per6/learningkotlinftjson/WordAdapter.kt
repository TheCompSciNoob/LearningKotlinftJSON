package com.example.per6.learningkotlinftjson

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by per6 on 1/19/18.
 */
class WordAdapter(var data: List<Word>) : RecyclerView.Adapter<WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        return WordViewHolder(inflater.inflate(R.layout.word_card_view_layout, parent, false))
    }

    override fun onBindViewHolder(holder: WordViewHolder?, position: Int) {
        holder?.bind(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
