package com.example.myapplication1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btninsert.setOnClickListener{

            var name=edtfrname.text.toString()
            var des=edtfrdes.text.toString()
            var price=edtfrprice.text.toString().toInt()

            var fruit=fruit(name,des,price)
            var db=Dbhelper(this)
            var flag=db.insert(fruit)
            edtfrname.setText("")
            edtfrdes.setText("")
            edtfrprice.setText("")
            if(flag)
            {
                Toast.makeText(this,"record inserted successfully!",Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(this,"Error!",Toast.LENGTH_LONG).show()
            }

        }
        btnviewall.setOnClickListener{
            var intent:Intent=Intent(this,Viewall::class.java)
            startActivity(intent)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId)
//        {
//            R.id.menulogout -> Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show()
//        }
        var id=item.itemId
        if(id.equals(R.id.menulogout))
        {
            var prefer:SharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
            var pr_edit=prefer.edit()
            pr_edit.clear()
            pr_edit.commit()

            var intent:Intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        return super.onOptionsItemSelected(item)
    }
}