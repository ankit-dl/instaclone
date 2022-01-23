package com.ankit.inguram.ui.feed.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankit.data.model.GalleryResponse
import com.ankit.inguram.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "FeedViewModel"
class FeedViewModel : ViewModel() {
    val repo = Repository()
    private val _feedLiveData = MutableLiveData<List<GalleryResponse.Data>>()

    val feedLiveData: LiveData<List<GalleryResponse.Data>> = _feedLiveData

    fun updateFeed(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (type) {
                "hot" -> {
                    _feedLiveData.postValue(repo.getHotFeeds())
                }
                "top" -> _feedLiveData.postValue(repo.getTopFeeds())
                else -> {
                    Log.e(TAG, "updateFeed: ")
                }
            }
        }

    }

}