package com.sbhachu.bootstrap.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sbhachu.bootstrap.application.Properties
import com.sbhachu.bootstrap.model.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    val TAG: String = this@ApiClient.javaClass.simpleName

    lateinit var template: IApiTemplate
        private set

    private object HOLDER {
        val INSTANCE: ApiClient = ApiClient()
    }

    companion object {
        val instance: ApiClient by lazy { HOLDER.INSTANCE }
    }

    private constructor() {
        val requestInterceptor: RequestInterceptor = RequestInterceptor.instance
        val client: OkHttpClient = OkHttpClient.Builder()
                .readTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
                .addNetworkInterceptor(requestInterceptor)
                .build()

        val gson: Gson = GsonBuilder()
                .setDateFormat(Constants.API_DATE_FORMAT)
                .create()

        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Properties.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()

        template = retrofit.create(IApiTemplate::class.java)
    }
}