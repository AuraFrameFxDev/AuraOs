# UsersApi

All URIs are relative to *https://api.aurafx.dev/v1*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**usersMeGet**](UsersApi.md#usersMeGet) | **GET** users/me | Get current user profile |
| [**usersMePut**](UsersApi.md#usersMePut) | **PUT** users/me | Update current user profile |



Get current user profile

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import dev.aurakai.auraframefx.api.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)

launch(Dispatchers.IO) {
    val result : User = webService.usersMeGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**User**

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Update current user profile

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import dev.aurakai.auraframefx.api.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val usersMePutRequest : UsersMePutRequest =  // UsersMePutRequest | 

launch(Dispatchers.IO) {
    val result : User = webService.usersMePut(usersMePutRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **usersMePutRequest** | **UsersMePutRequest**|  | |

### Return type

**User**

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

