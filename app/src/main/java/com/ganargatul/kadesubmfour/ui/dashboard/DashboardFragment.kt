package com.ganargatul.kadesubmfour.ui.dashboard

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganargatul.kadesubmfour.R
import com.ganargatul.kadesubmfour.adapter.LeagueAdapter
import com.ganargatul.kadesubmfour.model.LeagueItems
import com.ganargatul.kadesubmfour.ui.pastevent.PastEvent
import com.ganargatul.kadesubmfour.ui.searchevent.SearchEvent
import org.jetbrains.anko.support.v4.startActivity

class DashboardFragment : Fragment() {


    private var items: MutableList<LeagueItems> = mutableListOf()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerView = root.findViewById(R.id.rv_list_league)
        recyclerView.layoutManager= LinearLayoutManager(context)
        setHasOptionsMenu(true)
        initdata()
        return root
    }
    @SuppressLint("Recycler")
    private fun initdata() {
        val name = resources.getStringArray(R.array.name_league)
        val description = resources.getStringArray(R.array.description)
        val image = resources.obtainTypedArray(R.array.photo_league)
        val id = resources.getIntArray(R.array.id_league)
        val adapter = context?.let {
            LeagueAdapter(it,items){

                var nowItems = LeagueItems(it.name,it.description,it.image,it.id)
                startActivity<PastEvent>("Data" to nowItems)

            }
        }
        items.clear()
        for (i in name.indices){
            items.add(LeagueItems(name[i],description [i],image.getResourceId(i,0),id[i]))
        }
        recyclerView.adapter = adapter

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater?.inflate(R.menu.toolbar_menu,menu)
        val searchManager = this.activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search_menu).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                    startActivity<SearchEvent>("query" to query)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })


    }
}