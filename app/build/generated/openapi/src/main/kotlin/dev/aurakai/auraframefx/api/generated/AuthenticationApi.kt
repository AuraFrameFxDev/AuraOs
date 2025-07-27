package dev.aurakai.auraframefx.api.generated

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import dev.aurakai.auraframefx.api.model.AuthLoginPost200Response
import dev.aurakai.auraframefx.api.model.AuthRegisterPostRequest
import dev.aurakai.auraframefx.api.model.Error
import dev.aurakai.auraframefx.api.model.User

interface AuthenticationApi {
    /**
     * Login user
     * 
     * Responses:
     *  - 200: Login successful
     *  - 401: Invalid credentials
     *
     * @param username 
     * @param password 
     * @param grantType  (optional, default to "password")
     * @return [AuthLoginPost200Response]
     */
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun authLoginPost(@Field("username") username: kotlin.String, @Field("password") password: kotlin.String, @Field("grant_type") grantType: kotlin.String? = "password"): Response<AuthLoginPost200Response>

    /**
     * Register a new user
     * 
     * Responses:
     *  - 201: User registered successfully
     *  - 400: Invalid input
     *
     * @param authRegisterPostRequest 
     * @return [User]
     */
    @POST("auth/register")
    suspend fun authRegisterPost(@Body authRegisterPostRequest: AuthRegisterPostRequest): Response<User>

}
