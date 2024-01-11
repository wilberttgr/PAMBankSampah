package com.example.pambanksampah.ui.theme.halaman

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pambanksampah.R
import com.example.pambanksampah.data.Pelapor
import com.example.pambanksampah.navigasi.DestinasiNavigasi

object DetailsDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_pelapor
    const val pelaporIdArg = "itemId"
    val routeWithArgs = "$route/{$pelaporIdArg}"
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