package com.sbhachu.bootstrap.network

import android.util.Log
import com.sbhachu.bootstrap.BuildConfig
import com.sbhachu.bootstrap.application.KotlinApplication.Companion.app
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor private constructor() : Interceptor {

    private val TAG: String = this@RequestInterceptor.javaClass.simpleName

    private object Holder {
        val INSTANCE: RequestInterceptor = RequestInterceptor()
    }

    companion object {
        val instance: RequestInterceptor by lazy {
            Holder.INSTANCE
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        val response: Response

        val t1: Long = System.nanoTime()

        if (BuildConfig.DEBUG) {
            Log.d(TAG, ">>> HTTP ${request.method().toUpperCase()} ${request.url()}")
        }

        val updatedRequest: Request = request.newBuilder()
                .addHeader("X-Device-ID", app.deviceId())
                .addHeader("X-App-Version", app.version())
                .build();

        response = chain.proceed(updatedRequest)

        val t2 = System.nanoTime()

        if (BuildConfig.DEBUG) {
            Log.d(TAG, "<<< HTTP ${response.code()} ${response.request().url()} " +
                    "(${response.body().contentLength()} bytes) in ${((t2 - t1) / 1e6)}ms")
        }

        return response;
    }

}