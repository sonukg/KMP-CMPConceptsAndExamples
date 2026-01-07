package org.sonukg

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import datastoresharedprefencesexample.composeapp.generated.resources.Res
import datastoresharedprefencesexample.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch

@Composable
@Preview
fun App(appDataStore: AppDataStore) {
    MaterialTheme {
        val appDataStoreRepo = AppDataStoreRepository(appDataStore.dataStore)

        val isAuthenticated by appDataStoreRepo.isAuthenticatedFlow.collectAsStateWithLifecycle(
            initialValue = false
        )

        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { scope.launch { appDataStoreRepo.setIsAuthenticated(true) } }) {
                Text("Set in DataStore Pref")
            }
            Text("Is Authenticated in DataStore Pref: $isAuthenticated")
        }
    }
}