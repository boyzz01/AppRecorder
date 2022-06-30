package com.akggames.sdk

import ApiService
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.akggames.sdk.api.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Request {


    open fun send_otp(context: Context,email: String?) {
        var apiInterface: ApiService = ApiClient.getClient(context).create(ApiService::class.java)

        apiInterface.sendOTP("ardysyahputra01@gmail.com").enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("AKGGAMESSDK","Response : "+response.body())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("AKGGAMESSDK","Response : "+t.message)
            }

        })
    }

    fun s(c: Context?, message: String?) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show()
    }
}