package com.example.banksampah

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.banksampah.model.EditViewModel
import com.example.banksampah.model.PenyediaViewModel
import com.example.banksampah.navigasi.DestinasiNavigasi
import com.example.banksampah.navigasi.SampahTopAppBar
import kotlinx.coroutines.launch

object ItemEditDestination : DestinasiNavigasi {
    override val route = "edit"
    override val titleRes = R.string.edit_lapor
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SampahTopAppBar(
                title = "History",
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                EntryPelaporBody(
                    uiStatePelapor = viewModel.pelaporUiState,
                    onPelaporValueChange = viewModel::updateUiState,
                    onSaveClick = {
                        // Note: If the user rotates the screen very fast, the operation may get cancelled
                        // and the item may not be updated in the Database. This is because when config // change occurs, the Activity will be recreated and the remember CoroutineScope will
                        // be cancelled since the scope is bound to composition.
                        coroutineScope.launch {
                            viewModel.updatePelapor()
                            navigateBack()
                        }
                    },
                    onBack = navigateBack,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }

    }
}