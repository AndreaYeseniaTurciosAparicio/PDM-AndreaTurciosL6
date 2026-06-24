package com.example.retrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.model.meal
import com.example.retrofit.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

class MealsViewModel : ViewModel() {

    var users by mutableStateOf<List<meal>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadMeals() {

        viewModelScope.launch {

            isLoading = true

            try {

                users = RetrofitInstance
                    .api
                    .getUsers()

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                isLoading = false
            }
        }
    }
}