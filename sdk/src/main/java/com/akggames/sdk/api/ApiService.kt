
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("auth/users/register")
    suspend fun registerUser(
        @Field("email") email:String,
        @Field("password") password:String,
    ):ResponseBody

    @FormUrlEncoded
    @POST("auth/send_otp")
    fun sendOTP(
        @Field("email") email:String
    ):Call<ResponseBody>
}