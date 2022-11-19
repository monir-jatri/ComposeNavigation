package com.soyaeeb.composenavigation.navigation

sealed class Screen(
    val route : String,
){
    object RepoListScreen : Screen("repo_list")
    object ProfileScreen : Screen("profile_screen")
}
