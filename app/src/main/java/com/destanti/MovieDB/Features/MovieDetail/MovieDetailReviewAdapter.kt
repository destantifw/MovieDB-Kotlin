package com.destanti.MovieDB.Features.MovieDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.destanti.MovieDB.R
import com.destanti.MovieDB.data.Model.ReviewResult
import kotlinx.android.synthetic.main.item_user_review.view.*

class MovieDetailReviewAdapter(private val mContext: Context, private val userList: List<ReviewResult>)
    : RecyclerView.Adapter<MovieDetailReviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_user_review, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(userList[position])
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemCount(): Int = userList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(items: ReviewResult) {
            itemView.authorTextView.text = items.author
            itemView.reviewContentTextView.text = items.content
        }
    }
}
