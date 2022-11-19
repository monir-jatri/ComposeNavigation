package com.soyaeeb.feature_profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.soyaeeb.common.ErrorScreen
import com.soyaeeb.common.LoadingScreen
import com.soyaeeb.common.util.LoadingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackArrowClicked: () -> Unit
) {
    val viewModel: ProfileViewModel = hiltViewModel()
    val profileInfo by viewModel.profileInfoState.collectAsState()
    val visibleScreen by viewModel.visibleScreenState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profile") },
                navigationIcon = {
                    IconButton(onClick = { onBackArrowClicked.invoke() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back Arrow"
                        )
                    }
                },
            )
        },
        content = {
            when(visibleScreen){
                LoadingScreen.IDLE -> {}
                LoadingScreen.LOADING -> LoadingScreen()
                LoadingScreen.ERROR ->  ErrorScreen()
                LoadingScreen.SUCCESS -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            model = profileInfo.profileApiEntity.avatar_url.ifEmpty { "https://avatars.githubusercontent.com/u/73017060?v=4" },
                            contentDescription = "profile_avatar",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = profileInfo.profileApiEntity.name,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = profileInfo.profileApiEntity.login)
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = profileInfo.profileApiEntity.bio.ifEmpty { "Bio Not Found" })
                        Spacer(modifier = Modifier.height(4.dp))
                        Divider()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            ProfileInfoItem(profileInfo.profileApiEntity.public_repos, "Repository")
                            ProfileInfoItem(profileInfo.profileApiEntity.followers, "Followers")
                            ProfileInfoItem(profileInfo.profileApiEntity.following, "Following")
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ProfileInfoItem(
    count: Int, title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = title)
    }
}


