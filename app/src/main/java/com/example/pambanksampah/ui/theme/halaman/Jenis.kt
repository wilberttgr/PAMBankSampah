package com.example.pambanksampah.ui.theme.halaman

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pambanksampah.R
import com.example.pambanksampah.model.InputViewModel
import com.example.pambanksampah.model.PenyediaViewModel
import com.example.pambanksampah.navigasi.DestinasiNavigasi
import com.example.pambanksampah.navigasi.SampahTopAppBar

object DestinasiJenis : DestinasiNavigasi {
    override val route = "jenis"
    override val titleRes = R.string.jenis
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GarbageInformation(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InputViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            SampahTopAppBar(
                title = "Jenis Sampah",
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF4CAF50),
                            Color(0xFFFFFFFF)
                        )
                    )
                ) // Warna background hijau
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = navigateBack,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(40.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }

                Text(
                    text = "Jenis - jenis Sampah",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black // Warna teks putih
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Sampah merupakan hasil produksi manusia yang tidak akan pernah luput dari kehidupan sehari-hari. Lalu, jenis-jenis sampah apa yang biasanya kita hasilkan? Yuk, kenali di sini.\n" +
                        "Sampah jika dibiarkan saja akan mengganggu kebersihan lingkungan secara umum. Sampah dapat dibedakan menjadi dua macam, yaitu:",
                fontSize = 14.sp,
                color = Color.Black // Warna teks putih
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "1. Sampah Padat (Anorganik):",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black // Warna teks putih
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Sampah anorganik adalah sampah yang terdiri atas bahan-bahan anorganik. Contoh bahan-bahan anorganik adalah bahan logam, plastik, kaca, karet, dan kaleng. Sifat sampah anorganik adalah tahan lama dan sukar membusuk.\n" +
                        "Sampah ini tidak mudah diuraikan oleh mikroorganisme tanah. Apabila dibuang sembarangan, sampah anorganik dapat menimbulkan pencemaran tanah..",
                fontSize = 14.sp,
                color = Color.Black // Warna teks putih
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "2. Sampah Basah (Organik):",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black // Warna teks putih
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Sampah organik adalah sampah yang terdiri atas bahan-bahan organik. Sifat sampah organik adalah tidak tahan lama dan cepat membusuk. Biasanya sampah jenis ini berasal dari makhluk hidup. Contohnya adalah sayur-sayuran, buah-buahan yang membusuk, sisa nasi, daun, dan sebagainya.\n" +
                        "Sampah organik mudah diuraikan mikroorganisme tanah. Hanya saja jenis sampah akan menimbulkan bau kurang sedap jika tidak dikelola dengan baik.",
                fontSize = 14.sp,
                color = Color.Black // Warna teks putih
            )
        }
    }
}