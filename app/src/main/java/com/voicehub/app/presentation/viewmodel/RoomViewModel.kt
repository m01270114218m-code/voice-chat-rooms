package com.voicehub.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.voicehub.app.data.socket.SocketManager
import com.voicehub.app.data.webrtc.WebRTCManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class RoomMember(
    val id: String,
    val name: String,
    val isMuted: Boolean = false
)

data class RoomUiState(
    val roomId: String = "demo-room",
    val roomName: String = "غرفة مباشرة",
    val micEnabled: Boolean = true,
    val members: List<RoomMember> = listOf(
        RoomMember("1", "محمد", false),
        RoomMember("2", "سارة", false),
        RoomMember("3", "أحمد", true),
        RoomMember("4", "ليلى", false)
    )
)

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val socketManager: SocketManager,
    private val webRTCManager: WebRTCManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(RoomUiState())
    val uiState: StateFlow<RoomUiState> = _uiState.asStateFlow()

    init {
        webRTCManager.initialize()
    }

    fun toggleMic() {
        val current = _uiState.value
        val newState = current.copy(micEnabled = !current.micEnabled)
        _uiState.value = newState
        
        webRTCManager.toggleMic(newState.micEnabled)
    }

    override fun onCleared() {
        super.onCleared()
        webRTCManager.release()
    }
}
