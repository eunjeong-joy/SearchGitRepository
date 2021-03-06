package escape.com.searchgitrepository.search.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import escape.com.searchgitrepository.data.Repository

class ItemRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList = mutableListOf<Repository>()
    lateinit var onClick: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(onClick, parent)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ItemViewHolder)?.onBind(itemList[position])
    }

    fun addItem(item: Repository) {
        itemList.add(item)
    }

    fun clear() {
        itemList.clear()
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Repository {
        return itemList[position]
    }
}