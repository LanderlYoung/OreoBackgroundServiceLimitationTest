package io.githug.young.oreobackgroundservicelimitationtest.service

import android.content.Intent
import android.os.Handler
import android.util.Log

class NonStickyService : LifeCycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        Handler().postDelayed({
            try {
                startService(Intent(this, BlankService::class.java))
                Log.i(tag,"try to start service in the background success")
            } catch (e: IllegalStateException) {
                Log.i(tag, "try to start service in the background failed", e)
            }
        }, 5_000L)
    }
}
