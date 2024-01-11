package com.example.banksampah

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.banksampah.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun BankSampahApp(navController: NavHostController) {
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
        verticalArrangement = Arrangement.Center
    ) {
        // Card 1
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(16.dp, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(
                bottomEnd = 16.dp,
                bottomStart = 16.dp
            ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "BANK SAMPAH",
                    fontSize = 24.sp,
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Selamat Datang",
                    fontSize = 20.sp,
                    color = Color.Black,
                )
                Text(
                    text = "di Aplikasi Bank Sampah",
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp)) // Tambahkan sedikit ruang antara header dan CardScreen

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CardScreen(navController = navController)
        }


        // Navigate to EmptyScreen when the button is clicked
            Button(
                onClick = { navController.navigate("emptyScreen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(text = "Go to Empty Screen")
            }
        }
    }

@Composable
fun CardScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Menu Kategori",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )
        Divider(
            modifier = Modifier.padding(vertical = 10.dp),
            color = Color.White,
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.width(16.dp))
        // Card 1
        // Inside CardScreen
        Card(
            modifier = Modifier
                .width(295.dp)
                .height(200.dp)
                .clickable {navController.navigate(DestinasiForm.route)}        ) {
            // Your existing card content
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sampah),
                    contentDescription = "Plastic Bottle",
                    modifier = Modifier.height(100.dp),
                    contentScale = ContentScale.Crop
                )

                Text(text = "Laporkan Sampah", fontSize = 16.sp)

                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Color(0xFF4CAF50),
                    thickness = 2.dp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Card 2 and Card 3 side by side
        Row(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Card 2
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .clickable {navController.navigate(DestinasiJenis.route)}
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.jenis),
                        contentDescription = "Plastic Bag",
                        modifier = Modifier.height(100.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(text = "Jenis Sampah", fontSize = 16.sp)

                    Divider(
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = Color(0xFF4CAF50),
                        thickness = 2.dp
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Card 3
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .clickable {navController.navigate(DestinasiHistory.route)}
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.history),
                        contentDescription = "Styrofoam Box",
                        modifier = Modifier.height(100.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(text = "Riwayat", fontSize = 16.sp)

                    Divider(
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = Color(0xFF4CAF50),
                        thickness = 2.dp
                    )
                }
            }
        }
    }
}



