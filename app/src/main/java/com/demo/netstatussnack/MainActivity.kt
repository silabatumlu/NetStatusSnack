package com.demo.netstatussnack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.netstatussnack.ui.theme.NetStatusSnackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetStatusSnackTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val snackBarHostState = remember { SnackbarHostState() }
    val networkStatus = remember { NetworkStatus.Available }

    LaunchedEffect(networkStatus) {
        when (networkStatus) {
            NetworkStatus.Available -> {
                snackBarHostState.currentSnackbarData?.dismiss()
            }

            NetworkStatus.Unavailable -> {
                snackBarHostState.showSnackbar(
                    message = "No internet connection",
                    duration = SnackbarDuration.Indefinite
                )
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { innerPadding ->

        Text(
            text = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}