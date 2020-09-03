package com.destanti.MovieDB.Features.MovieDetail

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.destanti.MovieDB.Base.Injection
import com.destanti.MovieDB.R
import com.destanti.MovieDB.data.Model.MovieDetailModel
import com.destanti.MovieDB.data.Model.ReviewResult
import kotlinx.android.synthetic.main.acitivity_movie_detail.*


class MovieDetailActivity: AppCompatActivity(), MovieDetailContract.View  {

    private var mPresenter: MovieDetailContract.Presenter? = null

    private lateinit var movie : MovieDetailModel

    var userReviewList: MutableList<ReviewResult> = mutableListOf()

    lateinit var rvAdapter : MovieDetailReviewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.acitivity_movie_detail)

        MovieDetailPresenter(Injection.provideRepository(this), this, id = getIntentValue())

        val actionBar = supportActionBar

        if (actionBar != null){
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.setTitle("")
        }

        setAdapter()

        mPresenter?.start()

    }

    private fun getIntentValue():Int {
        return intent.getIntExtra("genreId", 80)
    }

    override fun showMovie(movie: MovieDetailModel) {
        this.movie = movie

        icStar.setImageResource(R.mipmap.icon_star)
        tfMovieTitle.text = movie.title
        genreList.text = movie.genres[0].name
        tvOverview.text = movie.overview
        tvCompanies.text = "Companis: " + movie.productionCompanies[0].name
        tvLanguages.text = "Companies: " + movie.originalLanguage
        tvCountries.text = "Country: Indonesia"
        tvRateAvg.text = movie.voteAverage.toString()
        tvRateCount.text = movie.voteCount.toString()


    }

    override fun showSuccessVideo(key: String) {
        trailerWebView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
        })

        val webSettings: WebSettings = trailerWebView.getSettings()
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true

        print("https://www.youtube.com/embed/$key")

        trailerWebView.loadUrl("https://www.youtube.com/embed/$key")
    }

    private fun setAdapter() {
        rvUserReviews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        rvAdapter = MovieDetailReviewAdapter(this, this.userReviewList)
        rvUserReviews.adapter = rvAdapter
    }

    override fun showError() {

    }

    override fun showSuccessUserReview(reviewResult: List<ReviewResult>) {
        this.userReviewList.clear()
        this.userReviewList.addAll(reviewResult)
        rvAdapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: MovieDetailContract.Presenter) {
        this.mPresenter = presenter
    }


}