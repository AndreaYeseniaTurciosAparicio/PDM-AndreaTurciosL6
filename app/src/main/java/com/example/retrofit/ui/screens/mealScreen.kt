package com.example.retrofit.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofit.data.model.meal
import com.example.retrofit.viewModel.MealsViewModel

@Composable
fun MealsScreen(
    viewModel: MealsViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    when {

        viewModel.isLoading -> {

            CircularProgressIndicator()
        }

        else -> {

            LazyColumn {

                items(viewModel.users) { meal ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = meal.strMeal
                            )

                            Text(
                                text = meal.strCategory
                            )

                            Text(
                                text = meal.strArea
                            )

                            Text(
                                text = meal.strMealThumb
                            )
                        }
                    }
                }
            }
        }
    }
}