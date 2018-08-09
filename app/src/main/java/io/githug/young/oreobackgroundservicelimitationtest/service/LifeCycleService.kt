package io.githug.young.oreobackgroundservicelimitationtest.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * ```
 * Author: taylorcyang@tencent.com
 * Date:   2018-08-09
 * Time:   16:20
 * Life with Passion, Code with Creativity.
 * ```
 */

abstract class LifeCycleService : Service() {
    protected val tag = this.javaClass.simpleName!!

    open override fun onCreate() {
        super.onCreate()
        Log.i(tag, "onCreate()")
    }

    open override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(tag, "onStartCommand(intent:$intent, flags:$flags, startId:$startId)")
        return super.onStartCommand(intent, flags, startId)
    }

    open override fun onBind(intent: Intent?): IBinder? {
        Log.i(tag, "onBind($intent)")
        return null
    }

    open override fun onDestroy() {
        Log.i(tag, "onDestroy()")
        super.onDestroy()
    }
}