package com.example.parcial_tp3_grupo_g3

import android.app.Application
import com.example.parcial_tp3_grupo_g3.core.Config
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ParcialTP3GrupoG3 : Application(){
    override fun onCreate() {
        super.onCreate()
        Config.url = "https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/"
        Config.apiKey = "123"
    }

}