package escape.com.searchgitrepository.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import escape.com.searchgitrepository.R
import escape.com.searchgitrepository.data.Repository
import escape.com.searchgitrepository.util.setShortNumberFormat
import escape.com.searchgitrepository.util.setUpdatedDateFormat
import kotlinx.android.synthetic.main.item_repository.view.*

class ItemViewHolder(onClick: (Int) -> Unit, parent: ViewGroup)
    : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)) {

    init {
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    fun onBind(item: Repository) {
        itemView.run {
            tv_name.text = item.fullName
            if(item.description.isNullOrEmpty()) {
                tv_description.visibility = View.GONE
            } else {
                tv_description.text = item.description
            }
            tv_star_count.text = setShortNumberFormat(item.stargazersCount)
            tv_language.text = item.language
            tv_update_date.text = resources.getString(R.string.update_at_label) + " " + setUpdatedDateFormat(item.pushedAt)
        }
    }

}