package net.vezk.colorflipper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.vezk.colorflipper.model.RandomProvider
import net.vezk.colorflipper.model.hexColor

//VIEW MODEL
class ViewModelHex: ViewModel() {
    val hexModel = MutableLiveData<hexColor>()
    fun randomHex() {
        val currentHex = RandomProvider.randomColor()
        hexModel.postValue(currentHex)
    }
}