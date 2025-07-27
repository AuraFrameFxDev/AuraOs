package dev.aurakai.auraframefx.api.generated

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import dev.aurakai.auraframefx.api.model.AiGeneratePost200Response
import dev.aurakai.auraframefx.api.model.AiGeneratePostRequest

interface AIServicesApi {
    /**
     * Generate content using AI
     * 
     * Responses:
     *  - 200: AI generation successful
     *  - 400: Invalid request
     *  - 429: Rate limit exceeded
     *
     * @param aiGeneratePostRequest 
     * @return [AiGeneratePost200Response]
     */
    @POST("ai/generate")
    suspend fun aiGeneratePost(@Body aiGeneratePostRequest: AiGeneratePostRequest): Response<AiGeneratePost200Response>

}
