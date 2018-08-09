package io.githug.young.oreobackgroundservicelimitationtest

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import io.githug.young.oreobackgroundservicelimitationtest.service.ApplicationBoundedService

/**
 * ```
 * Author: taylorcyang@tencent.com
 * Date:   2018-08-09
 * Time:   16:25
 * Life with Passion, Code with Creativity.
 * ```
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        bindService()
    }

    private fun bindService() {
        bindService(Intent(this, ApplicationBoundedService::class.java),
                object : ServiceConnection {
                    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                        Log.i("App", "onServiceConnected(name:$name, service:$service)")
                    }

                    override fun onServiceDisconnected(name: ComponentName?) {
                        Log.i("App", "onServiceDisconnected(name:$name)")
                    }
                }, Context.BIND_AUTO_CREATE)
    }
}