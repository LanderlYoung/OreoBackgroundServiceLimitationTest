package io.githug.young.oreobackgroundservicelimitationtest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
}
