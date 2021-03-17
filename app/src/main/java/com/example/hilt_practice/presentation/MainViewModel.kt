package com.example.hilt_practice.presentation

import androidx.lifecycle.*
import com.example.hilt_practice.domain.BlogRepo
import com.example.hilt_practice.domain.models.Blog
import com.example.hilt_practice.domain.state.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val blogRepo: BlogRepo,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState = MutableLiveData<DataState<List<Blog>>>()
    val dataState: LiveData<DataState<List<Blog>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetBlogsEvent -> {
                    blogRepo.getBlogs()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .collect()
                }

                is MainStateEvent.None -> {
                }
            }
        }
    }

}

sealed class MainStateEvent {
    object GetBlogsEvent : MainStateEvent()
    object None : MainStateEvent()
}