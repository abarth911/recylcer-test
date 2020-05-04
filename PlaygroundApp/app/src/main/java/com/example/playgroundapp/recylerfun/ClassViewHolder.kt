package com.example.playgroundapp.recylerfun

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playgroundapp.R

/**
 * Created on 04.05.20
 * @company arconsis IT-Solutions GmbH
 */
class ClassViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

    val textView: TextView by lazy { containerView.findViewById<TextView>(R.id.textView)}

    fun bind(string: String) {
        textView.text = string
    }
}