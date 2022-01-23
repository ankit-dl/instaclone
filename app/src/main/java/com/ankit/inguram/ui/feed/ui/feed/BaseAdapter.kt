package com.ankit.inguram.ui.feed.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import base.*
import com.ankit.inguram.data.model.Feed

class BaseAdapter(private val delegate: Delegate<*>) : RecyclerView.Adapter<BaseVH<RVItem, *>>() {
    private val itemList = mutableListOf<RVItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH<RVItem, *> {
        return VHFactory.getVH(viewType, LayoutInflater.from(parent.context), delegate)
    }

    override fun onBindViewHolder(holder: BaseVH<RVItem, *>, position: Int) {
        holder.bind(itemList[position], position)


    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun getItemViewType(position: Int): Int {
        return itemList[position].viewType
    }

    fun setData(data: List<Feed>) {
        itemList.clear()
        itemList.addAll(data)
        notifyDataSetChanged()

    }
}

