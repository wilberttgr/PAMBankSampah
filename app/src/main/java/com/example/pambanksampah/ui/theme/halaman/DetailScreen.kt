package com.example.pambanksampah.ui.theme.halaman

import com.example.pambanksampah.R
import com.example.pambanksampah.navigasi.DestinasiNavigasi

object DetailsDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_pelapor
    const val pelaporIdArg = "itemId"
    val routeWithArgs = "$route/{$pelaporIdArg}"
}