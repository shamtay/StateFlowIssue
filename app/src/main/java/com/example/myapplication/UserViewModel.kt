package com.example.myapplication

import androidx.lifecycle.MutableLiveData

class UserViewModel(
    val name: String
) {
    // val nameFlow = MutableStateFlow(name)
    val nameFlow = MutableLiveData(name)
}