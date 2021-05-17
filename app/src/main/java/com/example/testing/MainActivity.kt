package com.example.testing

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.Adapter.ContestAdapter
import com.example.testing.Model.contestItem
import com.example.testing.Repository.ContestRepository
import com.example.testing.ViewModel.ContestViewModel
import com.example.testing.ViewModel.ContestViewModelFactory
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Circle
import com.github.ybq.android.spinkit.style.DoubleBounce
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var listcontest: List<contestItem>


    private lateinit var recyclerView: RecyclerView
    private lateinit var displayList: List<contestItem>

    private lateinit var contestAdapter: ContestAdapter

    private lateinit var contestViewModel: ContestViewModel

    private lateinit var progressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar = findViewById<View>(R.id.spin_kit) as ProgressBar

        val doubleBounce: Sprite = Circle()
        progressBar.indeterminateDrawable = doubleBounce


        initialize()
        floatingActionButton.setOnClickListener {
            initialize()
        }


    }

    private fun initialize() {
        recyclerView = findViewById(R.id.recyclerView)
        contestAdapter = ContestAdapter(this, ArrayList())
        recyclerView.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = contestAdapter

        }
        val contestRepository = ContestRepository()
        val viewModelFactory = ContestViewModelFactory(contestRepository)
        contestViewModel = ViewModelProvider(this, viewModelFactory)[ContestViewModel::class.java]
        contestViewModel.getContest()
        contestViewModel.contestMutableLiveData.observe(this, Observer {
            listcontest = it
            displayList = it


            contestAdapter.setData(it as ArrayList<contestItem>)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val menuItem = menu!!.findItem(R.id.search)
        if (menuItem != null) {

            val searchView = menuItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }


                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {

                        displayList = emptyList()

                        /* displayList.forEach {

                             Log.d("TAG",it.site)

                         }*/

                        val search = newText.toLowerCase(Locale.getDefault())

                        listcontest.forEach {

                            //Log.d("TAG",it.site)

                            if (it.site.toLowerCase(Locale.getDefault()).contains(search)) {

                                displayList += it

                            }

                        }

                        if (displayList.isNotEmpty()) {

                            val cadapter = ContestAdapter(
                                this@MainActivity,
                                displayList as ArrayList<contestItem>
                            )

                            recyclerView.apply {

                                layoutManager = LinearLayoutManager(this@MainActivity)

                                adapter = cadapter

                            }
                        }


                    } else {
                        displayList = emptyList()

                        recyclerView.adapter!!.notifyDataSetChanged()

                    }


                    return true
                }
            })
        }


        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

