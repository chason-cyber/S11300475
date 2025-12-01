package tw.edu.pu.csim.tcyang.s11300475

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.Image // 引入 Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource // 引入 painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import tw.edu.pu.csim.tcyang.s11300475.ui.theme.S11300475Theme

import androidx.compose.foundation.shape.CircleShape // 引入 CircleShape
import androidx.compose.ui.draw.clip // 引入 clip Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
        windowInsetsController.hide(WindowInsetsCompat.Type.navigationBars())

        setContent {
            S11300475Theme {
                MainScreen(

                    authorInfo = "作者：資管二A 陳宇謙"
                )
            }
        }
    }
}

@Composable
fun MainScreen(authorInfo: String) {

    val context = LocalContext.current
    val resources = context.resources
    val displayMetrics = resources.displayMetrics

    val screenWidthPx = displayMetrics.widthPixels
    val screenHeightPx = displayMetrics.heightPixels

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFF00))
                .padding(innerPadding),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Image(
                painter = painterResource(id = R.drawable.happy),
                contentDescription = "服務大考驗圖片",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

            // 4. 文字間距高度 10dp
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "瑪利亞基金會服務大考驗",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = authorInfo,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "螢幕大小: ${screenWidthPx} * ${screenHeightPx} ",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "成績: 0分",
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}