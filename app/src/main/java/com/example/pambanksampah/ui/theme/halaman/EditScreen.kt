package com.example.pambanksampah.ui.theme.halaman

import com.example.pambanksampah.R
import com.example.pambanksampah.navigasi.DestinasiNavigasi

object ItemEditDestination : DestinasiNavigasi {
    override val route = "edit"
    override val titleRes = R.string.edit_lapor
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}