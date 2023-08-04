package com.kanha.daggerhiltandretrofit.main

import com.kanha.daggerhiltandretrofit.data.models.CurrencyResponse
import com.kanha.daggerhiltandretrofit.util.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}