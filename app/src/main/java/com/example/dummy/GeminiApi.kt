package com.example.dummy

import com.example.dummy.models.GeminiRequest
import com.example.dummy.models.GeminiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApi {
    @Headers("Content-Type: application/json")
    @POST("v1beta/models/gemini-1.5-flash-latest:generateContent")
    fun generateContent(
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): Call<GeminiResponse>
}
