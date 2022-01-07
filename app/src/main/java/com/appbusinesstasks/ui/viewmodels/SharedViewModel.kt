package com.appbusinesstasks.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appbusinesstasks.core.data.models.JetpackTask
import com.appbusinesstasks.core.data.models.Priority
import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.core.data.models.api.EnterpriseApi
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.core.data.repository.NetworkRepository
import com.appbusinesstasks.core.data.repository.UserRepository
import com.appbusinesstasks.core.db.models.User
import com.appbusinesstasks.utils.Action
import com.appbusinesstasks.utils.RequestState
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
    val description: MutableState<String> = mutableStateOf("")
    val priority: MutableState<Priority> = mutableStateOf(Priority.LOW)

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks =
        MutableStateFlow<RequestState<List<JetpackTask>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<JetpackTask>>> = _allTasks

    private val _searchedTasks =
        MutableStateFlow<RequestState<List<JetpackTask>>>(RequestState.Idle)
    val searchedTasks: StateFlow<RequestState<List<JetpackTask>>> = _searchedTasks

    private val _sortState = MutableStateFlow<RequestState<Priority>>(RequestState.Idle)
    val sortState: StateFlow<RequestState<Priority>> = _sortState

    private val _allUsers = MutableStateFlow<List<User>>(emptyList())
    val allUsers: StateFlow<List<User>> = _allUsers

    private val _allTaskApi = MutableStateFlow<List<TaskApi>>(emptyList())
    val allTaskApi: StateFlow<List<TaskApi>> = _allTaskApi

    private val _employeeApi = MutableStateFlow<List<EmployeeApi>>(emptyList())
    val employeeApi: StateFlow<List<EmployeeApi>> = _employeeApi

    private val _enterpriseApi = MutableStateFlow<List<EnterpriseApi>>(emptyList())
    val enterpriseApi: StateFlow<List<EnterpriseApi>> = _enterpriseApi

    private val _selectedTask = MutableStateFlow<TaskApi>(TaskApi(1,"","","","","",""))
    val selectedTask: StateFlow<TaskApi> = _selectedTask

    fun loadData(){
        viewModelScope.launch {
            try {
                val result1 = networkRepository.getEmployees()
                _employeeApi.value = result1

                val result2 = networkRepository.getEnterprises()
                _enterpriseApi.value = result2

                val result3 = networkRepository.getTasks()
                _allTaskApi.value = result3
            }
            catch (e: Exception){e.printStackTrace()}
        }
    }

    fun getSelectedTask(id: Int){
        val searchedTask = allTaskApi.value.filter { it.id == id.toLong() }
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

    fun getAllUsers(){
        viewModelScope.launch {
            userRepository.getAllUsers.collect {
                _allUsers.value = it
            }
        }
    }
}