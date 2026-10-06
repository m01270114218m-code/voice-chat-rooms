package com.voicehub.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voicehub.app.data.remote.RoomDto
import com.voicehub.app.data.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val rooms: List<RoomDto> = listOf(
        RoomDto("1", "غرفة 1", "مباشر", 120),
        RoomDto("2", "غرفة 2", "VIP", 88),
        RoomDto("3", "غرفة 3", "محادثة", 214),
        RoomDto("4", "غرفة 4", "مفتوح", 170)
    ),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val roomRepository: RoomRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadRooms()
    }

    fun loadRooms() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val rooms = roomRepository.getRooms()
                _uiState.value = _uiState.value.copy(
                    rooms = if (rooms.isEmpty()) _uiState.value.rooms else rooms,
                    isLoading = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Error loading rooms"
                )
            }
        }
    }
}
