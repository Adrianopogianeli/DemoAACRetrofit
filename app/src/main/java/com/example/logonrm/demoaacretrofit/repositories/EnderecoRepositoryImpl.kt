package com.example.logonrm.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import com.example.logonrm.demoaacretrofit.api.EnderecoAPI
import com.example.logonrm.demoaacretrofit.entities.EnderecoResponse

/**
 * Created by logonrm on 03/03/2018.
 */

class EnderecoRepositoryImpl : EnderecoRepository{

    private val enderecoAPI: EnderecoAPI

    override fun buscarEndereco(cep: String):
            LiveData<EnderecoResponse> {

    }


}