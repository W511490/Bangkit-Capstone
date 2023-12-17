package com.example.ceriakids.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ceriakids.data.pref.UserModel
import com.example.ceriakids.data.repository.UserRepository
import kotlinx.coroutines.launch
import org.json.JSONException

class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

//    private val _isLoading = MutableLiveData<Boolean>()
//    val _isLoading = LiveData<Boolean>
//        get() = _isLoading
//
//    fun signIn(email: String, password: String) {
//        _isLoading.value = true
//
//        val client = ApiConfig.getApiService().signIn(email, password)
//
//        client.enqueue(object : Callback<ResponseLogin> {
//            override fun onResponse(
//
//                call: Call<ResponseLogin>,
//                response: Response<ResponseLogin>,
//            ) {
//                if (response.isSuccessful) {
//                    val githubResponse = response.body()
//                    saveSession(
//                        UserModel(
//                            token = githubResponse?.loginResult?.token!!,
//                            isLogin = true
//                        )
//                    )
//
//                    _isMessage.value = githubResponse.message!!
//                    _isLoading.value = false
//
//                } else {
//
//                    val str = response.errorBody()!!.string()
//                    try {
//                        val json = JSONObject(str)
//
//                        _isMessage.value =
//                            json.getString("message")
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//
//
//                }
//
//
//                _isLoading.postValue(false)
//            }
//
//            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//
//                _isLoading.postValue(false)
//            }
//        })
//    }
}