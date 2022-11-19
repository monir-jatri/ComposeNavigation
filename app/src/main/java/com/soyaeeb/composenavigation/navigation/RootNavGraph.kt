package com.soyaeeb.composenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.soyaeeb.feature_profile.ProfileScreen
import com.soyaeeb.features_repolist.RepoListScreen

@Composable
fun RootNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.RepoListScreen.route
    ) {
        composable(route = Screen.RepoListScreen.route){
            RepoListScreen{
                navController.navigate(Screen.ProfileScreen.route)
            }
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen{
                navController.navigate(Screen.RepoListScreen.route)
            }
        }
    }
}