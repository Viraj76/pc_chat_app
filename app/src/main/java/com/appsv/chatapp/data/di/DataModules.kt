package com.appsv.chatapp.data.di

import com.appsv.chatapp.data.remote.ChatApi
import com.appsv.chatapp.data.repository.ChatsRepositoryImpl
import com.appsv.chatapp.domain.repository.ChatsRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun provideChatApi() : ChatApi{
    return Retrofit.Builder()
        .baseUrl("http://192.168.100.102:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ChatApi::class.java)
}

fun provideChatsRepository(chatApi: ChatApi) : ChatsRepository{
    return ChatsRepositoryImpl(chatApi)
}

val dataModule = module {

    single{
        provideChatApi()
    }

    single {
        provideChatsRepository(get())
    }

}