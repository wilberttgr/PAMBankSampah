package com.example.pambanksampah.ui.theme.halaman

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pambanksampah.R
import com.example.pambanksampah.model.DetailPelapor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    onBackClick: () -> Unit,
    onValueChange: (DetailPelapor) -> Unit = {},
    detailPelapor: DetailPelapor,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4CAF50),
                        Color(0xFFFFFFFF)
                    )
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Mengganti IconButton dengan Icon dan menggunakan Modifier.clickable

        }
        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = stringResource(id = R.string.medication_name),
            style = MaterialTheme.typography.bodyLarge
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = detailPelapor.nama,
            onValueChange = { onValueChange(detailPelapor.copy(nama = it))},
            placeholder = { Text(text = "Masukkan nama lengkap") },
        )

        Text(
            text = stringResource(id = R.string.tgl_penjemputan),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = detailPelapor.tangal_penjemputan,
            onValueChange = { onValueChange(detailPelapor.copy(tangal_penjemputan = it)) },
            placeholder = { Text(text = "Masukkan tanggal") },
        )
        Text(
            text = stringResource(id = R.string.alamat),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = detailPelapor.alamat,
            onValueChange = { onValueChange(detailPelapor.copy(alamat = it))},
            placeholder = { Text(text = "Masukkan alamat") },
        )
        Text(
            text = stringResource(id = R.string.catatan),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = detailPelapor.catatan,
            onValueChange = { onValueChange(detailPelapor.copy(catatan = it)) },
            placeholder = { Text(text = "Masukkan catatan tambahan") },
        )
        Text(
            text = stringResource(id = R.string.weight),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = detailPelapor.berat.toString(),
            onValueChange = { onValueChange(detailPelapor.copy(berat = it.toIntOrNull() ?:0)) },
            placeholder = { Text(text = "Masukkan berat") },
        )

        Text(
            text = stringResource(id = R.string.total_price),
            style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = PriceCalculator.calculateTotalPrice(detailPelapor.berat),
            onValueChange = { onValueChange(detailPelapor.copy(total_harga = it.toIntOrNull()?:0)) },
            readOnly = true,
            placeholder = { Text(text = "Harga total") },
        )
    }
}

object PriceCalculator {
    private const val PRICE_PER_KG = 1500

    fun calculateTotalPrice(weight: Int): String {
        val totalPrice = weight * PRICE_PER_KG
        return "Rp $totalPrice"
    }
}