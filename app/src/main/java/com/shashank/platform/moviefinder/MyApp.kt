package com.shashank.platform.moviefinder

import android.app.Application
import android.content.Context

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        mContext = applicationContext
    }

    companion object {
        private var mContext: Context? = null
        private var mInstance: MyApp? = null

        @Synchronized
        fun getInstance(): MyApp? {
            return mInstance
        }
    }

    fun setConnectivityListener(listener: ConnectivityReceiver.ConnectivityReceiverListener) {
        ConnectivityReceiver.connectivityReceiverListener = listener
    }

}