package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    val imageRes: Int
    val textRes: Int

    val onClick: () -> Unit = {
        when (currentStep) {
            1 -> {
                squeezeCount = (2..4).random()
                currentStep = 2
            }
            2 -> {
                squeezeCount--
                if (squeezeCount == 0) {
                    currentStep = 3
                }
            }
            3 -> {
                currentStep = 4
            }
            4 -> {
                currentStep = 1
            }
        }
    }

    when (currentStep) {
        1 -> {
            imageRes = R.drawable.lemon_tree
            textRes = R.string.page_one
        }
        2 -> {
            imageRes = R.drawable.lemon_squeeze
            textRes = R.string.page_two
        }
        3 -> {
            imageRes = R.drawable.lemon_drink
            textRes = R.string.page_three
        }
        else -> {
            imageRes = R.drawable.lemon_restart
            textRes = R.string.page_four
        }
    }

    LemonadeScreen(
        imageRes = imageRes,
        textRes = textRes,
        onImageClick = onClick
    )
}

@Composable
fun LemonadeScreen(
    imageRes: Int,
    textRes: Int,
    onImageClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                modifier = Modifier
                    .clickable(onClick = onImageClick)
                    .padding(16.dp)
                    .size(250.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(textRes),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    AppTheme {
        LemonadeApp()
    }
}
