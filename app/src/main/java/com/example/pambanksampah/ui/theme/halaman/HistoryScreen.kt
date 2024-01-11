package com.example.pambanksampah.ui.theme.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pambanksampah.R
import com.example.pambanksampah.data.Pelapor
import com.example.pambanksampah.navigasi.DestinasiNavigasi

// Assuming the history data is stored in a list
object DestinasiHistory : DestinasiNavigasi {
    override val route = "history"
    override val titleRes = R.string.history
}

@Composable
fun DataPelapor(
    pelapor: Pelapor,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DataItem(label = "Nama", value = pelapor.nama)
            DataItem(label = "Tanggal Penjemputan", value = pelapor.tangal_penjemputan)
            DataItem(label = "Alamat", value = pelapor.alamat)
            DataItem(label = "Catatan", value = pelapor.catatan)
            DataItem(label = "Berat", value = pelapor.berat.toString())
            DataItem(label = "Total Harga", value = PriceCalculator.calculateTotalPrice(pelapor.berat))
        }
    }
}
@Composable
private fun DataItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 2.dp),
            color = Color.Gray
        )
    }
}
