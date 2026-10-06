package com.voicehub.app.di

import android.content.Context
import com.voicehub.app.data.local.SessionManager
import com.voicehub.app.data.remote.ApiService
import com.voicehub.app.data.remote.RetrofitClient
import com.voicehub.app.data.repository.AuthRepository
import com.voicehub.app.data.repository.RoomRepository
import com.voicehub.app.data.socket.SocketManager
import com.voicehub.app.data.webrtc.WebRTCManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager {
        return SessionManager(context)
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return RetrofitClient.api
    }

    @Singleton
    @Provides
    fun provideAuthRepository(
        api: ApiService,
        sessionManager: SessionManager
    ): AuthRepository {
        return AuthRepository(api, sessionManager)
    }

    @Singleton
    @Provides
    fun provideRoomRepository(api: ApiService): RoomRepository {
        return RoomRepository(api)
    }

    @Singleton
    @Provides
    fun provideSocketManager(): SocketManager {
        return SocketManager()
    }

    @Singleton
    @Provides
    fun provideWebRTCManager(@ApplicationContext context: Context): WebRTCManager {
        return WebRTCManager(context)
    }
}
