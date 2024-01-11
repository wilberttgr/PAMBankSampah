package com.example.banksampah

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.banksampah.data.Pelapor
import com.example.banksampah.model.DetailsViewModel
import com.example.banksampah.model.ItemDetailsUiState
import com.example.banksampah.model.PenyediaViewModel
import com.example.banksampah.model.toPelapor
import com.example.banksampah.navigasi.DestinasiNavigasi
import com.example.banksampah.navigasi.SampahTopAppBar
import kotlinx.coroutines.launch

object DetailsDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_pelapor
    const val pelaporIdArg = "itemId"
    val routeWithArgs = "$route/{$pelaporIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SampahTopAppBar(
                title = stringResource(DetailsDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItem(uiState.value.detailPelapor.id) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(20.dp),
                containerColor = Color(0xFF4CAF50)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(R.string.edit_siswa),
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        // Add .background(...) here
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
                )
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {
            ItemDetailsBody(
                itemDetailsUiState = uiState.value,
                onDelete = {
                    coroutineScope.launch {
                        viewModel.deleteItem()
                        navigateBack()
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun ItemDetailsBody(
    itemDetailsUiState: ItemDetailsUiState,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        var deleteConfirmationRequired by rememberSaveable {
            mutableStateOf(false)
        }
        ItemDetails(
            pelapor = itemDetailsUiState.detailPelapor.toPelapor(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { deleteConfirmationRequired = true },
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            Text(stringResource(R.string.delete))
        }
        if (deleteConfirmationRequired) {
            DeleteConfirmationDialog(
                onDeleteConfirm = {
                    deleteConfirmationRequired = false
                    onDelete()
                },
                onDeleteCancel = { deleteConfirmationRequired = false },
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@Composable
fun ItemDetails(
    pelapor: Pelapor, modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        color = Color.White,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            ItemDetailsRow(
                labelResID = R.string.medication_name,
                itemDetail = pelapor.nama,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray) // Divider
            ItemDetailsRow(
                labelResID = R.string.tgl_penjemputan,
                itemDetail = pelapor.tangal_penjemputan,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray) // Divider
            ItemDetailsRow(
                labelResID = R.string.alamat,
                itemDetail = pelapor.alamat,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray) // Divider
            ItemDetailsRow(
                labelResID = R.string.catatan,
                itemDetail = pelapor.catatan,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray) // Divider
            ItemDetailsRow(
                labelResID = R.string.weight,
                itemDetail = pelapor.berat.toString(),
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray) // Divider
            ItemDetailsRow(
                labelResID = R.string.total_price,
                itemDetail = PriceCalculator.calculateTotalPrice(pelapor.berat),
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
        }
    }
}


@Composable
private fun ItemDetailsRow(
    @StringRes labelResID: Int, itemDetail: String, modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(labelResID),
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = itemDetail,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
        )
    }
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier = Modifier
) {
    AlertDialog(onDismissRequest = { /* Do nothing */ },
        title = { Text(stringResource(R.string.attention),
            color = Color.Black
        ) },
        text = { Text(stringResource(R.string.delete),
            color = Color.Black
        ) },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = stringResource(R.string.no),
                    color = Color.Black)
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = stringResource(R.string.yes),
                    color = Color.Black)
            }
        }
    )
}