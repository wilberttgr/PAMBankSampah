package com.example.banksampah

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.banksampah.data.Pelapor
import com.example.banksampah.model.HistoryViewModel
import com.example.banksampah.model.PenyediaViewModel
import com.example.banksampah.navigasi.DestinasiNavigasi
import com.example.banksampah.navigasi.SampahTopAppBar

// Assuming the history data is stored in a list
object DestinasiHistory : DestinasiNavigasi {
    override val route = "history"
    override val titleRes = R.string.history
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (Int) -> Unit = {},
    viewModel: HistoryViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            SampahTopAppBar(
                title = "History",
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
        modifier = modifier
    ) { innerpadding ->
        val uiStatePelapor by viewModel.historyUiState.collectAsState()
        BodyHome(
            itemPelapor = uiStatePelapor.listPelapor,
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .padding(innerpadding)
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF4CAF50),
                            Color(0xFFFFFFFF)
                        )
                    )
                ),
            onPelaporClick = onDetailClick
        )
    }
}

@Composable
fun BodyHome(
    itemPelapor: List<Pelapor>,
    modifier: Modifier = Modifier,
    onPelaporClick: (Int) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        ListPelapor(
            itemPelapor = itemPelapor,
            modifier = Modifier
                .padding(horizontal = 8.dp),
            onItemClick = { onPelaporClick(it.id) }

        )

    }
}

@Composable
fun ListPelapor(
    itemPelapor: List<Pelapor>,
    modifier: Modifier = Modifier,
    onItemClick: (Pelapor) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = itemPelapor, key = { it.id }) { nadiv ->
            DataPelapor(
                pelapor = nadiv,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onItemClick(nadiv) }
            )
        }
    }
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
