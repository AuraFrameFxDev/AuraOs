# AuthenticationApi

All URIs are relative to *https://api.aurafx.dev/v1*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**authLoginPost**](AuthenticationApi.md#authLoginPost) | **POST** auth/login | Login user |
| [**authRegisterPost**](AuthenticationApi.md#authRegisterPost) | **POST** auth/register | Register a new user |



Login user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import dev.aurakai.auraframefx.api.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val username : kotlin.String = username_example // kotlin.String | 
val password : kotlin.String = password_example // kotlin.String | 
val grantType : kotlin.String = grantType_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : AuthLoginPost200Response = webService.authLoginPost(username, password, grantType)
}
```

### Parameters
| **username** | **kotlin.String**|  | |
| **password** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **grantType** | **kotlin.String**|  | [optional] [default to &quot;password&quot;] |

### Return type

**AuthLoginPost200Response**

### Authorization



### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json


Register a new user

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import dev.aurakai.auraframefx.api.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthenticationApi::class.java)
val authRegisterPostRequest : AuthRegisterPostRequest =  // AuthRegisterPostRequest | 

launch(Dispatchers.IO) {
    val result : User = webService.authRegisterPost(authRegisterPostRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **authRegisterPostRequest** | **AuthRegisterPostRequest**|  | |

### Return type

**User**

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

