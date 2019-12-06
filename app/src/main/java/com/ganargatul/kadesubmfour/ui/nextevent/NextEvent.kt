package com.ganargatul.kadesubmfour.ui.nextevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganargatul.kadesubmfour.R
import com.ganargatul.kadesubmfour.adapter.NextEventAdapter
import com.ganargatul.kadesubmfour.model.LeagueItems
import com.ganargatul.kadesubmfour.model.NextEventsItems
import com.ganargatul.kadesubmfour.test.repository.nextevent.NextEventRepository
import com.ganargatul.kadesubmfour.ui.detailnextevent.NextEventDetail
import org.jetbrains.anko.startActivity

class NextEvent : AppCompatActivity(), NextEventView {
    override fun onDataLoaded(data: List<NextEventsItems>) {
        showItems(data)
    }

    override fun onDataError() {
//        Log.d("error"m)
    }


    lateinit var recyclerview: RecyclerView
    lateinit var adapter: NextEventAdapter
//    lateinit var nextEventViewModel: NextEventViewModel
    lateinit var pb : ProgressBar
    lateinit var presenter: NextEventPresenter
    lateinit var view: NextEventView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_event)
        pb= findViewById(R.id.pb_next_event)
        recyclerview= findViewById(R.id.rv_list_next_event)
        recyclerview.layoutManager= LinearLayoutManager(baseContext)
        val items= intent.getParcelableExtra<LeagueItems>("Data")
        presenter = NextEventPresenter(this, NextEventRepository())
        presenter.loadData(items.id.toString())
    }

    private fun showItems(it1: List<NextEventsItems>) {
        adapter= NextEventAdapter(baseContext,it1){
            var nowItems = NextEventsItems(it.idEvent,it.strEvent,it.dateEvent,it.strTime,it.idHomeTeam,it.idAwayTeam)
            startActivity<NextEventDetail>("Data" to nowItems)
        }

        recyclerview.adapter = adapter
    }
    override fun showLoading() {
        pb.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb.visibility = View.GONE
    }

    override fun showTeamList(data: List<NextEventsItems>) {
        showItems(data)
    }
}
