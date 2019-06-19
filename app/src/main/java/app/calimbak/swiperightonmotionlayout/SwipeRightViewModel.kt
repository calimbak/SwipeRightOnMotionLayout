package app.calimbak.swiperightonmotionlayout

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class SwipeRightViewModel: ViewModel() {

    private val stream = MutableLiveData<SwipeRightModel>()

    val modelStream: LiveData<SwipeRightModel>
        get() = stream

    private val data = listOf(
        SwipeRightCardModel(backgroundColor = Color.parseColor("#E91E63")),
        SwipeRightCardModel(backgroundColor = Color.parseColor("#2196F3")),
        SwipeRightCardModel(backgroundColor = Color.parseColor("#F44336")),
        SwipeRightCardModel(backgroundColor = Color.parseColor("#9E9E9E"))
    )
    private var currentIndex = 0

    private val topCard
        get() = data[currentIndex % data.size]
    private val bottomCard
        get() = data[(currentIndex + 1) % data.size]

    init {
        updateStream()
    }

    fun swipe() {
        currentIndex += 1
        updateStream()
    }

    private fun updateStream() {
        stream.value = SwipeRightModel(
            top = topCard,
            bottom = bottomCard
        )
    }

}