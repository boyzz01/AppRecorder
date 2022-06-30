
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akggames.sdk.viewmodel.MainViewModel




class ViewModelFactory(private val retrofitService: ApiService) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(this.retrofitService) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }


}