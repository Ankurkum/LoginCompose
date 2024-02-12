package com.example.newloginappcomp.view.ui.list_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newloginappcomp.data.models.UserResponseItem
import com.example.newloginappcomp.data.remote.IApiInterface
import com.example.newloginappcomp.data.remote.UserListRepository
import com.example.newloginappcomp.view.ui.list_screen.ui.theme.NewLoginAppCompTheme
import com.example.newloginappcomp.viewModels.ListViewModel

class ListMainActivity : ComponentActivity() {

    lateinit var listViewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listViewModel = ListViewModel(UserListRepository(IApiInterface.getAPiInterface()))

        setContent {
            NewLoginAppCompTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2(listViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting2(listViewModel: ListViewModel) {
    val userDataList = listViewModel.userList.collectAsState()
    LazyColumn {
        items(userDataList.value){item ->
            UserRow(userResponseItem = item)
        }
    }
}

@Composable
fun UserRow( userResponseItem: UserResponseItem) {
    Card(elevation = CardDefaults.cardElevation(5.dp),
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()) {
        Text(text = userResponseItem.name)
    }
}