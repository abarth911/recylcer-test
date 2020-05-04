package com.example.playgroundapp.recylerfun

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playgroundapp.R
import kotlinx.android.extensions.LayoutContainer

/**
 * Created on 04.05.20
 * @company arconsis IT-Solutions GmbH
 */
class ClassViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    val textView: TextView by lazy { containerView.findViewById<TextView>(R.id.textView)}

    fun bind(classWrapper: ClassWrapper, onClick: (ClassWrapper) -> Unit) {
        textView.text = classWrapper.data
        containerView.setOnClickListener { onClick(classWrapper) }
    }
}