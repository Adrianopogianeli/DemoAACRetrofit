package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.widget.MultiAutoCompleteTextView
import com.example.logonrm.demoaacretrofit.entities.EnderecoResponse
import com.example.logonrm.demoaacretrofit.repositories.EnderecoRepository
import com.example.logonrm.demoaacretrofit.repositories.EnderecoRepositoryImpl

/**
 * Created by logonrm on 03/03/2018.
 */

class MainViewModel: ViewModel(){

    val isLoading : MutableLiveData<Boolean> = MutableLiveData()

    private val enderecoReposiory: EnderecoRepository
    private val mApiResponse: MediatorLiveData<EnderecoResponse> =
            MediatorLiveData()

    val apiRespnse: LiveData<EnderecoResponse>
    get() = mApiResponse

    init {
        enderecoReposiory = EnderecoRepositoryImpl()


    }

    fun pesquisarEndereco(cep : String): LiveData<EnderecoResponse>{
        isLoading.postValue(true)
        mApiResponse.addSource(
                enderecoReposiory.buscarEndereco(cep)){
            apiRespnse -> mApiResponse.value = apiRespnse
            isLoading.postValue(false)
        }
        return mApiResponse
    }
}