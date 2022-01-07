package com.appbusinesstasks.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appbusinesstasks.core.data.models.Priority
import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.core.data.models.api.EnterpriseApi
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.core.data.repository.NetworkRepository
import com.appbusinesstasks.core.data.repository.UserRepository
import com.appbusinesstasks.core.db.models.User
import com.appbusinesstasks.utils.Action
import com.appbusinesstasks.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)

    val id: MutableState<Int> = mutableStateOf(0)
    val title: MutableState<String> = mutableStateOf("")
    var listOfTask: List<TaskApi> = emptyList()

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allUsers = MutableStateFlow<List<User>>(emptyList())
    val allUsers: StateFlow<List<User>> = _allUsers

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _userTask = MutableStateFlow<List<TaskApi>>(emptyList())
    val userTask: StateFlow<List<TaskApi>> = _userTask

    private val _employeeApi = MutableStateFlow<List<EmployeeApi>>(emptyList())
    val employeeApi: StateFlow<List<EmployeeApi>> = _employeeApi

    private val _enterpriseApi = MutableStateFlow<List<EnterpriseApi>>(emptyList())
    val enterpriseApi: StateFlow<List<EnterpriseApi>> = _enterpriseApi

    private val _selectedTask = MutableStateFlow<TaskApi>(TaskApi(1,"","",
        "","","","", ""))
    val selectedTask: StateFlow<TaskApi> = _selectedTask

    fun loadData(){
        viewModelScope.launch {
            try {
                userRepository.getAllUsers.collect { user ->

                    val result1 = networkRepository.getEmployees()
                    _employeeApi.value = result1.filter {
                        it.user.name == user.first().name && it.user.password == user.first().password
                    }

                    val result2 = networkRepository.getEnterprises()
                    result2.forEach { enterprise ->
                        enterprise.employees.forEach { employee ->
                            if (employee.user.name == user.first().name && employee.user.password == user.first().password){
                                _enterpriseApi.value = listOf(enterprise)
                            }
                        }
                    }

                    _userTask.value = employeeApi.value.first().tasks
                    listOfTask = employeeApi.value.first().tasks
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSelectedTask(id: Int){
        val searchedTask = userTask.value.filter { it.id == id.toLong() }
        _selectedTask.value = searchedTask.first()
    }

    fun persistSortingState(priority: Priority){
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    fun addTask(taskApi: TaskApi){
        viewModelScope.launch {
            networkRepository.addTask(taskApi = taskApi)
        }
    }

    fun deleteTask(id: Long){
        viewModelScope.launch {
            networkRepository.deleteTask(id)
        }
    }

    fun updateListOfTasks(name: String){
        val newList = listOfTask.filter { it.name == name }
        _userTask.value = newList
    }

    fun reloadListOfTask(){
        _userTask.value = listOfTask
    }

    fun getAllUsers(){
        viewModelScope.launch {
            userRepository.getAllUsers.collect {
                _allUsers.value = it
            }
        }
    }
}