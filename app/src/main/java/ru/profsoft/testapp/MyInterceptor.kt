package ru.profsoft.testapp

import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException

class MyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        if (!response.isSuccessful) throw IOException("smt went wrong")

        return response
    }
}