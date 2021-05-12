package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.Adapter.ContestAdapter
import com.example.testing.Model.contestItem
import com.example.testing.Repository.ContestRepository
import com.example.testing.ViewModel.ContestViewModel
import com.example.testing.ViewModel.ContestViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var contestAdapter: ContestAdapter
    private lateinit var contestViewModel: ContestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val contestRepository=ContestRepository()
        val viewModelFactory=ContestViewModelFactory(contestRepository)
        contestViewModel= ViewModelProvider(this,viewModelFactory)[ContestViewModel::class.java]


        contestViewModel.getContest()
        contestViewModel.contestMutableLiveData.observe(this, Observer {
            contestAdapter.setData(it as ArrayList<contestItem>)
            progressBar.visibility= View.GONE
            recyclerView.visibility= View.VISIBLE
        })


    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        contestAdapter= ContestAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=contestAdapter
        }
    }
}