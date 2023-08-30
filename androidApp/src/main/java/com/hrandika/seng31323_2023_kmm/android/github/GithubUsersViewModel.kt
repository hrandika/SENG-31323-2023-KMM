package com.hrandika.seng31323_2023_kmm.android.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hrandika.seng31323_2023_kmm.github.GithubRepository
import com.hrandika.seng31323_2023_kmm.github.GithubUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class GithubUserState(
    val users: List<GithubUser> = emptyList(),
    val count:Int  = 0
)

class GithubUsersViewModel(repository: GithubRepository = GithubRepository()) : ViewModel() {
    private var _state = MutableStateFlow(GithubUserState())
    val state: StateFlow<GithubUserState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val users = repository.fetchUsers()
            _state.value = GithubUserState(users = users, count = users.size + 1)
        }
    }
}