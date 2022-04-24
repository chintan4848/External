package com.example.myapplication1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin.setOnClickListener{
            var u_name=edtloginname.text.toString()
            var password=edtloginpwd.text.toString()
            if(u_name=="admin" || password=="admin")
            {
                var shredpref:SharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
                var prefedit=shredpref.edit()
                prefedit.putString("username",u_name)
                prefedit.commit()//save

                //main activity
                var intent:Intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        btnsignUp.setOnClickListener {

        }
    }
}