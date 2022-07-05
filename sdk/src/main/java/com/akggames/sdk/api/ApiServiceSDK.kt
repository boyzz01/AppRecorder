
import com.akggames.sdk.model.ResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiServiceSDK {


    //Registration Method
    @FormUrlEncoded
    @POST("auth/users/register")
    fun registerUser(
        @Field("email") email:String,
        @Field("password") password:String,
    ):Call<ResponseModel>

    @FormUrlEncoded
    @POST("auth/send_otp")
    fun sendOTP(
        @Field("email") email:String
    ):Call<ResponseModel>

    @FormUrlEncoded
    @POST("auth/check_otp")
    fun checkOTP(
        @Field("email") email:String,
        @Field("otp") otp:String
    ):Call<ResponseModel>


    //Authentication Method
    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("gameProvider") gameProvider:String,
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<ResponseModel>


    //User Management
    @GET("me")
    fun userDetail(
        @Header("Authorization") authHeader : String
    ):Call<ResponseModel>


    @GET("me/accounts")
    fun userAccount(
        @Header("Authorization") authHeader : String
    ):Call<ResponseModel>

}