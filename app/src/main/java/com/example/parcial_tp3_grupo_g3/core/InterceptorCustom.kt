package com.example.parcial_tp3_grupo_g3.core

import okhttp3.Interceptor
import okhttp3.Response

object InterceptorCustom : Interceptor {
    private val API_KEY = Config.apiKey
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .header("api_key", API_KEY)
            .build()
        return chain.proceed(request)
    }

}