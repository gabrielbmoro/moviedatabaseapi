package com.gabrielbmoro.programmingchallenge.koin

import androidx.room.Room
import com.gabrielbmoro.programmingchallenge.BuildConfig
import com.gabrielbmoro.programmingchallenge.koin.api.ApiRepository
import com.gabrielbmoro.programmingchallenge.koin.api.ApiRepositoryImpl
import com.gabrielbmoro.programmingchallenge.koin.dataBase.DataBaseFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        ApiRepositoryImpl(
                Retrofit.Builder()
                        .baseUrl(BuildConfig.baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(
                                OkHttpClient.Builder()
                                        .connectTimeout(15, TimeUnit.SECONDS)
                                        .readTimeout(15, TimeUnit.SECONDS)
                                        .build()
                        )
                        .build()
                        .create(ApiRepository::class.java)
        )
    }
}

val dataBaseModule = module {
    single {
        Room.databaseBuilder(get(), DataBaseFactory::class.java, BuildConfig.dataBaseName).build().favoriteMoviesDAO()
    }
}