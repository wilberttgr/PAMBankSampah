package com.example.pambanksampah.ui.theme.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pambanksampah.R
import com.example.pambanksampah.navigasi.DestinasiNavigasi

object DestinasiLogin : DestinasiNavigasi {
    override val route = "jenis"
    override val titleRes = R.string.app_name
}
@Composable
fun EmptyScreen(
    navController: NavHostController,
    onNextButtonClicked:()-> Unit,

    ) {
    Column(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4CAF50),
                        Color(0xFFFFFFFF)
                    )
                )
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(4.dp), // Add a subtle shadow
            shape = RoundedCornerShape(
                bottomEnd = 16.dp,
                bottomStart = 16.dp
            ),
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .size(325.dp),
                painter = painterResource(R.drawable.sampah),
                contentDescription = "Illustration Finance"
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0x44DD03),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 24.dp),
                    text = "Bank Sampah",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "Selamat Datang Di Bank Sampah",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick =  onNextButtonClicked,
                    modifier = Modifier
                        .height(48.dp)
                        .width(180.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
