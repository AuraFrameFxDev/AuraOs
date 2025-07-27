package dev.aurakai.auraframefx.api.generated

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.google.gson.annotations.SerializedName

import dev.aurakai.auraframefx.api.model.User
import dev.aurakai.auraframefx.api.model.UsersMePutRequest

interface UsersApi {
    /**
     * Get current user profile
     * 
     * Responses:
     *  - 200: User profile retrieved successfully
     *  - 401: Unauthorized
     *
     * @return [User]
     */
    @GET("users/me")
    suspend fun usersMeGet(): Response<User>

    /**
     * Update current user profile
     * 
     * Responses:
     *  - 200: User profile updated successfully
     *  - 401: Unauthorized
     *  - 400: Invalid input
     *
     * @param usersMePutRequest 
     * @return [User]
     */
    @PUT("users/me")
    suspend fun usersMePut(@Body usersMePutRequest: UsersMePutRequest): Response<User>

}
