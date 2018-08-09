package io.githug.young.oreobackgroundservicelimitationtest

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.githug.young.oreobackgroundservicelimitationtest.service.NonStickyService
import io.githug.young.oreobackgroundservicelimitationtest.service.StickyService
import kotlinx.android.synthetic.main.activity_main.button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            startService(Intent(this, NonStickyService::class.java))
            startService(Intent(this, StickyService::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        Log.i("MainActivity", "runningServices:\n${
        am.getRunningServices(100).filter {
            it.uid == Process.myUid()
        }.map {
            it.service
        }
        }")
    }
}
