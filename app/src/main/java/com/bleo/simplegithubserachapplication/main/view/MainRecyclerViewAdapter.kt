package com.bleo.simplegithubserachapplication.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bleo.simplegithubserachapplication.R
import com.bleo.simplegithubserachapplication.main.model.GithubRepositoryModel
import kotlinx.android.synthetic.main.main_recyclerview_item.view.*

class MainRecyclerViewAdapter: RecyclerView.Adapter<MainRecyclerViewViewHolder>() {

    var items: List<GithubRepositoryModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewViewHolder =
        MainRecyclerViewViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_recyclerview_item, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainRecyclerViewViewHolder, position: Int) {
        holder.bind(items[position])
    }

}


class MainRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: GithubRepositoryModel) {
        with(itemView) {
            repositoryName.text = model.name
            repositoryDescription.text = model.description
        }
    }
}