package com.example.ceriakids.di

import android.content.Context
import com.example.ceriakids.data.pref.UserPreference
import com.example.ceriakids.data.pref.dataStore
import com.example.ceriakids.data.repository.UserRepository

//object Injection {
//    fun provideRepository(context: Context): UserRepository {
//        val pref = UserPreference.getInstance(context.dataStore)
//        return UserRepository.getInstance(pref)
//    }
//}