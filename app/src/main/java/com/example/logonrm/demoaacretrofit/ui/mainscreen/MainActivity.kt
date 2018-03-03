package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.logonrm.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btPesquisar.setOnClickListener{
            mainViewModel.pesquisarEndereco(etCEP.text.toString())
        }

        mainViewModel.apiRespnse.observe(this, Observer {
            apiResponse ->
            if (apiResponse?.erro == null){
                Log.i("TAG", "SUCESSO")
                val end = apiResponse?.endereco
                val zueira = "A PINGAIADA TA ROLANDO SOLTA NESTE ENDEREÇO\n DBA + PINGA = DROP DATABASE !!!"
                tvResultado.text =
                                   "Logadouro: ${end?.logradouro}\n" +
                                   "Complemento: ${end?.complemento}\n" +
                                   "Bairro: ${end?.bairro}\n" +
                                   "Localidade: ${end?.localidade}\n" +
                                   "UF: ${end?.uf}\n" +
                                    "${zueira}"

            } else{
                Log.i("TAG", "ERRO ${apiResponse.erro}..." )
            }
        })

    }
}
