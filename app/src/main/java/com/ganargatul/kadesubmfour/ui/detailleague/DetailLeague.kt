package com.ganargatul.kadesubmfour.ui.detailleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.ganargatul.kadesubmfour.R
import com.ganargatul.kadesubmfour.connection.RetroConfig
import com.ganargatul.kadesubmfour.model.LeagueDetailsItem
import com.ganargatul.kadesubmfour.model.LeagueItems
import com.ganargatul.kadesubmfour.model.LeagueResponse
import com.ganargatul.kadesubmfour.test.repository.detailleague.DetailLeagueRepository
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response

class DetailLeague : AppCompatActivity(),DetailLeagueView {
    lateinit var name : TextView
    lateinit var desc : TextView
    lateinit var img : ImageView
    lateinit var website: TextView
    lateinit var progressbar : ProgressBar
    lateinit var presenter: DetailLeaguePresenter
    lateinit var items: LeagueItems
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        progressbar = findViewById(R.id.detail_league_prog)
        progressbar.visibility = View.VISIBLE
        items= intent.getParcelableExtra("Data")
        name = findViewById(R.id.title_detail)
        desc = findViewById(R.id.desc_detail)
        img = findViewById(R.id.image_detail)
        website = findViewById(R.id.website_detail)
        presenter = DetailLeaguePresenter(this, DetailLeagueRepository())
        presenter.loadData(items.id.toString())


    }
    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressbar.visibility = View.GONE    }

    override fun showTeamList(data: List<LeagueDetailsItem>) {
        show(data)
    }

    override fun onDataLoaded(data: List<LeagueDetailsItem>?) {
        show(data)
    }

    private fun show(data: List<LeagueDetailsItem>?) {
        items.image?.let { Picasso.get().load(it).into(img) }
        name.text = items.name
        desc.text = data?.get(0)?.strDescriptionEN
        website.text = data?.get(0)?.strWebsite
    }

    override fun onDataError() {
        progressbar.visibility = View.GONE    }



}
