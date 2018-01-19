package com.example.per6.learningkotlinftjson

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.word_card_view_layout.view.*

/**
 * Created by per6 on 1/19/18.
 */
class WordViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bind(word : Word) = with(itemView) {
        itemView.word.text = word.word
        itemView.score.text = "${word.score}"
        itemView.numSyllables.text = "${word.numSyllables}"
    }
}