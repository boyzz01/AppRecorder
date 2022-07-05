
import com.akggames.sdk.model.ResponseModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ResponseListener {

    fun onResponse(res: ResponseModel)
    fun onFailure(e: Throwable)
}