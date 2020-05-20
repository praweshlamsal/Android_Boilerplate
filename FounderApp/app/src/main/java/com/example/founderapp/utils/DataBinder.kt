@file:Suppress("unused")
package com.example.founderapp.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.founderapp.ui.PostAdapter

@BindingAdapter("adapter")
fun setAdapter(view:RecyclerView,adapter: PostAdapter){
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setAdapter(view: RecyclerView,layoutManager: LinearLayoutManager){
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view:RecyclerView,dividerItemDecoration:DividerItemDecoration){
    view.addItemDecoration(dividerItemDecoration)
}