package com.appbusinesstasks.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appbusinesstasks.core.data.repository.NetworkRepository
import com.appbusinesstasks.core.data.repository.UserRepository
import com.appbusinesstasks.core.db.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel
    @Inject constructor(
        private val userRepository: UserRepository,
        private val networkRepository: NetworkRepository
    ): ViewModel() {

    private val _allUsers = MutableStateFlow<List<User>>(emptyList())
    val allUsers: StateFlow<List<User>> = _allUsers

        fun getAllUsers(){
            viewModelScope.launch {
                userRepository.getAllUsers.collect {
                    _allUsers.value = it
                }
            }
        }

}