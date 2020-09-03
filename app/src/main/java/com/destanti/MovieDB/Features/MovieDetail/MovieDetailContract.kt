package com.destanti.MovieDB.Features.MovieDetail

import com.destanti.MovieDB.Base.BasePresenter
import com.destanti.MovieDB.Base.BaseView
import com.destanti.MovieDB.data.Model.MovieDetailModel
import com.destanti.MovieDB.data.Model.ReviewResult


class MovieDetailContract {

    interface View : BaseView<Presenter> {
        fun showMovie(movie: MovieDetailModel)
        fun showSuccessVideo(key: String)
        fun showError()
        fun showSuccessUserReview(reviewList: List<ReviewResult>)
    }

    interface Presenter : BasePresenter {
        fun getMovieDetail()
        fun getMovieVideo()
        fun getUserReview()
        val id: Int
    }

}