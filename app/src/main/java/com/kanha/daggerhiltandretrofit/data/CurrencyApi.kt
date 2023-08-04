package com.kanha.daggerhiltandretrofit.data

import com.kanha.daggerhiltandretrofit.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("v6/78820121674e6474441e1537/latest/USD")
    suspend fun getRates(
        @Query("base_code") base: String
    ): Response<CurrencyResponse>

}