package com.w4eret1ckrtb1tch.app30

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val listItems: List<Int>) :

    RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textCheckBox: CheckBox = itemView.findViewById(R.id.checkbox_item)

        fun onBind(item: Int) {
            val str = "${textCheckBox.text} $item"
            textCheckBox.text = str
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}