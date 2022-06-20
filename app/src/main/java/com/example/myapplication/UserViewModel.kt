package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow

class UserViewModel(
    val name: String
) {
    val nameFlow = MutableStateFlow(name)
    // val nameFlow = MutableLiveData(name)
}