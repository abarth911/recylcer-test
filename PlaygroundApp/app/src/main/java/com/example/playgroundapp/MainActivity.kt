package com.example.playgroundapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.example.playgroundapp.recylerfun.ClassAdapter
import com.example.playgroundapp.recylerfun.ClassType
import com.example.playgroundapp.recylerfun.ClassWrapper
import com.example.playgroundapp.recylerfun.TYPE_1
import com.example.playgroundapp.recylerfun.TYPE_2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val spanCount = 3
    val list = mutableListOf(
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "3"),
        ClassWrapper(type = ClassType.Type1, data = "3"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "3"),
        ClassWrapper(type = ClassType.Type1, data = "3"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1"),
        ClassWrapper(type = ClassType.Type1, data = "1")
    )

    val adapter = ClassAdapter { removeItem(it) }
    private val layoutManager by lazy { GridLayoutManager(this, spanCount) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        layoutManager()



        list.add(6, ClassWrapper(type = ClassType.Type2, data = "3"))

        adapter.submitList(list)
    }

    private fun removeItem(position: ClassWrapper) {
        list.remove(position)
        adapter.submitList(list)
    }

    private fun layoutManager() {
        layoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    TYPE_1 -> 1
                    TYPE_2 -> spanCount
                    else -> throw IllegalStateException()
                }
            }
        }
    }

    private fun setupRecycler() {
        recycler.adapter = adapter
        recycler.layoutManager = layoutManager
    }
}
