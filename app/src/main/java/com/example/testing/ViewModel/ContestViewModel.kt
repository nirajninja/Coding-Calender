package com.example.testing.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testing.Model.contestItem
import com.example.testing.Repository.ContestRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ContestViewModel(private  val contestRepository: ContestRepository):ViewModel() {


    val contestMutableLiveData:MutableLiveData<List<contestItem>> = MutableLiveData()


    fun getContest()
    {
        viewModelScope.launch {
            try {
                val response= contestRepository.getContest()
                contestMutableLiveData.value = response
            }
            catch (e:Exception)
            {
                Log.d("TAG","fail ho gya h tu be!!")
            }
        }
    }

}