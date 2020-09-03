package com.destanti.MovieDB.Features.MovieDetail

import com.destanti.MovieDB.Services.MovieDataSource
import com.destanti.MovieDB.data.Model.MovieDetailModel
import com.destanti.MovieDB.data.Model.ReviewModel
import com.destanti.MovieDB.data.Model.VideoDetail
import com.example.destanti.submission2.Services.MovieRepository

class MovieDetailPresenter(
    private val repository: MovieRepository,
    private val view: MovieDetailContract.View, override val id: Int)
    : MovieDetailContract.Presenter {

    val cbMovie = object : MovieDataSource.LoadMovieDetailCallback {
        override fun onFailed(throwable: Throwable) {
            print("presenter error"+ throwable.toString())
        }

        override fun onSuccess(movie: MovieDetailModel) {
            view.showMovie(movie)
        }
    }

    val cbVideo = object : MovieDataSource.LoadVideoDetailCallback {
        override fun onFailed(throwable: Throwable) {
            print("presenter error"+ throwable.toString())
        }

        override fun onSuccess(video: VideoDetail) {
            view.showSuccessVideo(video.results[0].key)
        }
    }

    val cbUserList = object : MovieDataSource.LoadUserReviewCallback {
        override fun onFailed(throwable: Throwable) {
            print("presenter error"+ throwable.toString())
        }

        override fun onSuccess(review: ReviewModel) {
            view.showSuccessUserReview(review.results)
        }
    }



    init {
        view.setPresenter(this)
    }

    override fun getMovieDetail() {
        repository.getMovieDetail(id, cbMovie)
    }


    override fun getMovieVideo() {
        repository.getVideoDetail(id,cbVideo )
    }

    override fun getUserReview() {
        repository.getUserReviewList(id, cbUserList)
    }


    override fun start() {
        getMovieDetail()
        getMovieVideo()
        getUserReview()
    }


}