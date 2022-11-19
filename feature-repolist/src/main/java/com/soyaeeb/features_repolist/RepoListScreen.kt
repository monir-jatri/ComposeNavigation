package com.soyaeeb.features_repolist

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.soyaeeb.model.entity.RepoItemApiEntity

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RepoListScreen(
    onRepoItemClick : () -> Unit
){
    val viewModel : RepoViewModel = hiltViewModel()
    val listState by viewModel.repoListState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "My Repo")}
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ){
            items(listState.repoList){ repo ->
                RepoItem(
                    repoItem = repo,
                    onRepoItemClick = onRepoItemClick
                )
                Divider()
            }
        }
    }
}


@Composable
fun RepoItem(
   repoItem: RepoItemApiEntity,
   onRepoItemClick: () -> Unit
){
    Column(
        modifier = Modifier
            .clickable {
                onRepoItemClick.invoke()
            }
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = repoItem.owner.avatar_url.ifEmpty { "https://avatars.githubusercontent.com/u/73017060?v=4" } ,
                contentDescription = "owner_avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = com.soyaeeb.assets.R.drawable.ic_baseline_person_24)
            )

            Column(
                modifier = Modifier
                    .height(90.dp)
                    .padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = repoItem.owner.login.ifEmpty { "Soyaeeb Monir" },
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
                Text(
                    text = repoItem.name,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            }
        }
        Text(text = repoItem.full_name)
        Text(text = repoItem.description.ifEmpty { "Description Not Found" })
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
           InfoItem(repoItem.language, Icons.Rounded.Info)
           InfoItem("${repoItem.stargazers_count} Star", Icons.Rounded.Star)
           InfoItem("${repoItem.fork_count} Forked", Icons.Rounded.Share)
        }
    }
}

@Composable
fun InfoItem(
    title: String,
    icon: ImageVector,
    contentDescription: String = ""
) {
    Row {
        Icon(icon,contentDescription)
        Text(text = title )
    }
}
