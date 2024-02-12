package com.example.newloginappcomp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newloginappcomp.data.models.UserResponseItem
import com.example.newloginappcomp.data.remote.UserListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListViewModel(userListRepository: UserListRepository): ViewModel() {

    val _userList = MutableStateFlow<List<UserResponseItem>>(listOf())
    val userList: StateFlow<List<UserResponseItem>>
        get() = _userList

    init {
        viewModelScope.launch {
            _userList.value = userListRepository.getUserData()
        }
    }

}