package com.destanti.MovieDB.Features.MovieList

import com.destanti.MovieDB.Services.MovieDataSource
import com.destanti.MovieDB.data.Model.MovieList
import com.destanti.MovieDB.data.Model.ReviewModel
import com.example.destanti.submission2.Services.MovieRepository

class MovieListPresenter(
    private val repository: MovieRepository,
    private val view: MovieListContract.View, override val genreId: Int)
    : MovieListContract.Presenter {

    val cbMovie = object : MovieDataSource.LoadMovieListByGenreCallback {
        override fun onFailed(throwable: Throwable) {
            print("presenter error"+ throwable.toString())
        }

        override fun onSuccess(movies: MovieList) {
            currentPage = movies.page
            view.showMovie(movies.results)
        }
    }

    private var currentPage: Int = 1
    private var totalPage: Int = 0


    init {
        view.setPresenter(this)
    }

    override fun getMovieList() {
        repository.getMovieListByGenre(genreId, currentPage, cbMovie)
    }

    override fun nextPage() {
        print("nextpage")
        val page = currentPage + 1
        if (page < totalPage) {
            repository.getMovieListByGenre(genreId, page, cbMovie)
        }
    }

    override fun start() {
        getMovieList()
    }




}