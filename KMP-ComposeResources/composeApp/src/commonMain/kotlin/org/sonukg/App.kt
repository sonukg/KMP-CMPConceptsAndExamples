package org.sonukg

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import kmp_composeresources.composeapp.generated.resources.Res
import kmp_composeresources.composeapp.generated.resources.Res.readBytes
import kmp_composeresources.composeapp.generated.resources.Workbench_Regular
import kmp_composeresources.composeapp.generated.resources.allStringResources
import kmp_composeresources.composeapp.generated.resources.app_name
import kmp_composeresources.composeapp.generated.resources.compose
import kmp_composeresources.composeapp.generated.resources.compose_multiplatform
import kmp_composeresources.composeapp.generated.resources.platforms
import kmp_composeresources.composeapp.generated.resources.plural_text
import kmp_composeresources.composeapp.generated.resources.simple_text
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.getResourceUri
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.pluralStringResource
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(Res.drawable.compose),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringResource(Res.string.app_name)
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = pluralStringResource(Res.plurals.plural_text,1, 1)
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = pluralStringResource(Res.plurals.plural_text,2, 3)
            )

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = stringArrayResource(Res.array.platforms).joinToString()
            )

            var customFont= FontFamily(Font(Res.font.Workbench_Regular))
            Text(
                fontFamily = customFont,
                modifier = Modifier.padding(top = 16.dp),
                text = stringArrayResource(Res.array.platforms).joinToString()
            )


            var fileContents by remember { mutableStateOf(ByteArray(0)) }
            LaunchedEffect(Unit){
                fileContents= readBytes("files/common-text.txt")
            }

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = fileContents.decodeToString()
            )

            val string =stringResource(Res.allStringResources["app_name"]!!)
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = string
            )

            val uri= Res.getUri("files/testData.json")
            println("uri: $uri")

            val scope=rememberCoroutineScope()
            var str=""
            scope.launch {
              str=  getString(Res.string.simple_text)
            }

            val str1 = stringResource(Res.string.simple_text)

            Text(modifier = Modifier.padding(top = 16.dp),
                text = str1
            )



        }
    }
}