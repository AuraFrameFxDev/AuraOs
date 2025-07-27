# AIServicesApi

All URIs are relative to *https://api.aurafx.dev/v1*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**aiGeneratePost**](AIServicesApi.md#aiGeneratePost) | **POST** ai/generate | Generate content using AI |



Generate content using AI

### Example
```kotlin
// Import classes:
//import org.openapitools.client.*
//import org.openapitools.client.infrastructure.*
//import dev.aurakai.auraframefx.api.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AIServicesApi::class.java)
val aiGeneratePostRequest : AiGeneratePostRequest =  // AiGeneratePostRequest | 

launch(Dispatchers.IO) {
    val result : AiGeneratePost200Response = webService.aiGeneratePost(aiGeneratePostRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **aiGeneratePostRequest** | **AiGeneratePostRequest**|  | |

### Return type

**AiGeneratePost200Response**

### Authorization



### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

