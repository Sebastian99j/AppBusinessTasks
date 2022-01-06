package com.appbusinesstasks.ui.screens.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appbusinesstasks.core.data.repository.NetworkRepository
import com.appbusinesstasks.core.db.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val networkRepository: NetworkRepository
): ViewModel() {
    private val _goNextScreen = MutableStateFlow<Boolean>(false)
    val goNextScreen: StateFlow<Boolean> = _goNextScreen

    fun authorize(name: String, password: String){
        val user = User(name = name, password = password)
        viewModelScope.launch {
            try {
                val result = networkRepository.validateUser(user = user)
                if (result.status == "ok"){
                    _goNextScreen.value = true
                }
            }
            catch (e: Exception){e.printStackTrace()}
        }
    }
}