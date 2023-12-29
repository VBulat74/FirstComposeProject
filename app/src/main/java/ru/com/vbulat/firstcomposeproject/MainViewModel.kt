package ru.com.vbulat.firstcomposeproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(500){
            add(
                InstagramModel(
                    id = it,
                    title = "Title: $it",
                    isFollowed = Random.nextBoolean(),
                )
            )
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models : LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(item : InstagramModel){
        val modifiedList = _models.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll {
            if (it.id == item.id){
                it.copy(isFollowed = !it.isFollowed)
            }else {
                it
            }
        }
        _models.value = modifiedList
    }
}