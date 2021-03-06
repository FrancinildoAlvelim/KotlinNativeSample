package com.github.florent37.sample.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.florent37.kotlinnative.data.Repository
import com.github.florent37.sample.R

class GithubAdapter(
        private val onRepoClicked: (Repository) -> Unit
) : RecyclerView.Adapter<RepoViewHolder>() {

    var data: List<Repository> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            RepoViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.cell_repo, parent, false),
                    onRepoClicked
            )
}

