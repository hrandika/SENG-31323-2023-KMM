package com.hrandika.seng31323_2023_kmm.android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.hrandika.seng31323_2023_kmm.android.common.PermissionDialog
import com.hrandika.seng31323_2023_kmm.android.common.RationaleDialog
import com.hrandika.seng31323_2023_kmm.android.github.GithubUsersViewModel
import com.hrandika.seng31323_2023_kmm.github.GithubUser
import android.Manifest

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    RequestNotificationPermissionDialog()
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GithubUsers()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestNotificationPermissionDialog() {
    val permissionState = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

    if (!permissionState.status.isGranted) {
        if (permissionState.status.shouldShowRationale) RationaleDialog()
        else PermissionDialog { permissionState.launchPermissionRequest() }
    }
}

@Composable
fun GithubUsers(
    vm: GithubUsersViewModel = viewModel()
) {
    val state by vm.state.collectAsState()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        for (user in state.users) {
            GithubUserCard(user)
        }
    }
}

@Composable
fun GithubUserCard(user:GithubUser) {
    Row(modifier = Modifier.padding(8.dp)) {
        AsyncImage(
            model = user.avatarUrl,
            contentDescription = user.login,
            modifier = Modifier.size(50.dp)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = user.login, fontSize = 20.sp)
            Text(text = user.nodeId, fontSize = 12.sp)
        }
    }
}