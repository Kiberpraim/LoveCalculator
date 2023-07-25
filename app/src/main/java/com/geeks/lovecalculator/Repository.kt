package com.geeks.lovecalculator

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.geeks.lovecalculator.remote.LoveModel
import com.geeks.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        var liveData = MutableLiveData<LoveModel>()
        RetrofitService().api.getPercentage(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("kiber", t.message.toString())
                }

            })
        return liveData
    }
}