package com.example.logonrm.demoaacretrofit.entities

/**
 * Created by logonrm on 03/03/2018.
 */

data class Endereco(
        val cep: String,
        val logradouro: String,
        val complemento: String,
        val bairro: String,
        val localidade: String,
        val uf: String
)

/*
"cep": "05879-480",
"logradouro": "Rua Agrópoli",
"complemento": "",
"bairro": "Chácara Santa Maria",
"localidade": "São Paulo",
"uf": "SP",
"unidade": "",
"ibge": "3550308",
"gia": "1004"
        */