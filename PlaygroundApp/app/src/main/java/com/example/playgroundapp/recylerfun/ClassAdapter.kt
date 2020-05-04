package com.example.playgroundapp.recylerfun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.util.ObjectsCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.playgroundapp.R

const val TYPE_1 = 0
const val TYPE_2 = 1

class ClassAdapter(private val onClick: (ClassWrapper) -> Unit) : ListAdapter<ClassWrapper, ClassViewHolder>(DIFF_CALLBACK) {

    override fun submitList(list: MutableList<ClassWrapper>?) {
        super.submitList(list?.map { it.copy() })
    }

    override fun getItemViewType(position: Int) = when (getItem(position).type) {
        ClassType.Type1 -> TYPE_1
        ClassType.Type2 -> TYPE_2
        else -> throw IllegalStateException()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        return when (viewType) {
            TYPE_1 -> ClassViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.type_1_holder, parent, false))
            TYPE_2 -> ClassViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.type_2_holder, parent, false))
            else -> throw IllegalStateException()
        }
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ClassWrapper>() {
            override fun areItemsTheSame(oldItem: ClassWrapper, newItem: ClassWrapper): Boolean {
                return ObjectsCompat.equals(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItem: ClassWrapper, newItem: ClassWrapper): Boolean {
                return ObjectsCompat.equals(oldItem.type, newItem.type) &&
                    oldItem.data == newItem.data

            }
        }
    }
}