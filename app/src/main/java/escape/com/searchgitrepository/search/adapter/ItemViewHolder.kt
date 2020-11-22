package escape.com.searchgitrepository.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import escape.com.searchgitrepository.R
import escape.com.searchgitrepository.data.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

class ItemViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)) {

    fun onBind(item: Repository) {
        itemView.run {
            tv_name.text = item.fullName
            tv_description.text = item.description
            tv_star_count.text = item.stargazersCount.toString()
            tv_language.text = item.language
            tv_update_date.text = item.pushedAt
        }
    }

}