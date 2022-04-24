package com.example.myapplication1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class flashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_screen)

        var shared:SharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
        var name=shared.getString("username","tt")

        Handler().postDelayed({
            if(name.equals("tt"))
            {
                var intent:Intent=Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
            else
            {
                var intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }


        },3000)
    }
}