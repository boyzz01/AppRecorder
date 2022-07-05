package com.akggames.sdk.api



import ApiServiceSDK
import ResponseListener
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.akggames.sdk.model.ResponseModel

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RequestSDK {

    private var responseListener: ResponseListener? = null
    private var apiInterface : ApiServiceSDK? = null


    fun init(url : String){
        if (apiInterface == null){
            apiInterface = ApiClient.getClient(url).create(ApiServiceSDK::class.java)
        }
    }

    fun call(responseListener: ResponseListener) : RequestSDK {
        this.responseListener = responseListener
        return this
    }

    fun sendOTP(email: String) : RequestSDK {
        apiInterface!!.sendOTP(email).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val responseModel : ResponseModel = response.body()!!
                responseListener!!.onResponse(responseModel)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                responseListener!!.onFailure(t)
            }

        })
        return this
    }

    fun registerUser(email : String,password : String) : RequestSDK{
        apiInterface!!.registerUser(email,password).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val responseModel : ResponseModel = response.body()!!
                responseListener!!.onResponse(responseModel)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                responseListener!!.onFailure(t)
            }

        })
        return this
    }

    fun checkOTP(email: String,otp : String):RequestSDK {
        apiInterface!!.checkOTP(email,otp).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val responseModel : ResponseModel = response.body()!!
                responseListener!!.onResponse(responseModel)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                responseListener!!.onFailure(t)
            }

        })
        return this
    }

    fun loginUser(gameProvider : String,email: String,password: String) : RequestSDK{
        apiInterface!!.login(gameProvider,email,password).enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val responseModel : ResponseModel = response.body()!!
                responseListener!!.onResponse(responseModel)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                responseListener!!.onFailure(t)
            }

        })
        return this
    }

    fun getUserDetail(token : String) : RequestSDK{
        apiInterface!!.userDetail("Bearer $token").enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val responseModel : ResponseModel = response.body()!!
                responseListener!!.onResponse(responseModel)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                responseListener!!.onFailure(t)
            }

        })
        return this
    }

    fun getUserAccount(token: String) : RequestSDK{
        apiInterface!!.userAccount("Bearer $token").enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val responseModel : ResponseModel = response.body()!!
                responseListener!!.onResponse(responseModel)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                responseListener!!.onFailure(t)
            }

        })
        return this
    }

}