package com.geeks.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geeks.lovecalculator.remote.LoveModel

class LoveViewModel : ViewModel(), java.io.Serializable {
    var repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
}