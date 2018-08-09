package io.githug.young.oreobackgroundservicelimitationtest.service

import android.content.Intent

class StickyService : LifeCycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }
}
