package com.voicehub.app.data.repository

import com.voicehub.app.data.remote.ApiService
import com.voicehub.app.data.remote.RoomDto

class RoomRepository(private val api: ApiService) {
    suspend fun getRooms(): List<RoomDto> {
        return try {
            api.getRooms()
        } catch (e: Exception) {
            emptyList()
        }
    }
}
