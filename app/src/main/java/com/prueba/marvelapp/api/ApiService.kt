package com.prueba.marvelapp.api

import android.provider.SyncStateContract
import com.prueba.marvelapp.util.Constants
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface ApiService {

    @GET("v1/public/characters?ts=1&apikey=${Constants.API_KEY}&hash=${Constants.HASH_KEY}")
    fun listCharacters(): Observable<Response>

    @GET("v1/public/characters/{characterId}?ts=1&apikey=${Constants.API_KEY}&hash=${Constants.HASH_KEY}")
    fun character(
        @Path("characterId") characterId: Int
    ): Observable<Response>



    companion object Factory {
        fun create(): ApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}