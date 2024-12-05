package ru.profsoft.testapp

import retrofit2.http.POST

interface ApiService {

    @POST("/todos/1")
    suspend fun getTest()
}
