package com.ksivol_project.shoppinglist.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.ksivol_project.shoppinglist.R
import com.ksivol_project.shoppinglist.databinding.ListNameItemBinding
import com.ksivol_project.shoppinglist.databinding.NoteListItemBinding
import com.ksivol_project.shoppinglist.entities.NoteItem
import com.ksivol_project.shoppinglist.entities.ShoppingListName
import com.ksivol_project.shoppinglist.utils.HtmlManager

class ShopListNameAdapter(private val listener: Listener) : ListAdapter<ShoppingListName, ShopListNameAdapter.ItemHolder>(ItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder.create(parent)

    override fun onBindViewHolder(holder: ItemHolder, position: Int) =
        holder.setData(getItem(position), listener)

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListNameItemBinding.bind(view)

        fun setData(shopListNameItem: ShoppingListName, listener: Listener) = with(binding) {
            tvListName.text = shopListNameItem.name
            tvTime.text = shopListNameItem.time
            itemView.setOnClickListener {

            }
            imDelete.setOnClickListener {
                listener.deleteItem(shopListNameItem.id!!)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_name_item, parent, false)
                )
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<ShoppingListName>() {
        override fun areItemsTheSame(oldItem: ShoppingListName, newItem: ShoppingListName): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ShoppingListName, newItem: ShoppingListName): Boolean =
            oldItem == newItem

    }

    interface Listener{
        fun deleteItem(id: Int)
        fun onClickItem(note: NoteItem)
    }


}