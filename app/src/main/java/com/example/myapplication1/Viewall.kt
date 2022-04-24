package com.example.myapplication1

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_viewall.*
import kotlinx.android.synthetic.main.custome_dialog.*

class Viewall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewall)

         updateRecycleView()

//        btnshow.setOnClickListener{
//
//            var id=edtid.text.toString().toInt()
//            var db=Dbhelper(this)
//            var arr=db.retriveAll()
//
//            for (i in 0..arr.size-1)
//            {
//                var obj=arr[i]
//                if(obj.id==id)
//                {
//                    Toast.makeText(this, "fruit name ${obj.fr_name}", Toast.LENGTH_SHORT).show()
//                    break
//                }
//            }
//            var i=0
//            while (true)
//            {
//                var obj=arr[i]
//                if(obj.id==id)
//                {
//                    Toast.makeText(this, "fruit name ${obj.fr_name}", Toast.LENGTH_SHORT).show()
//                    break
//                }
//                i++
//            }

       // }







    }
    fun delete(position:Int)
    {
        var db=Dbhelper(this)
        var arr=db.retriveAll()
        var fruit=arr.get(position)
        var id=fruit.id
       var flag= db.delete(id)
        if(flag)
        {
            Toast.makeText(this, "Record Deleted!!", Toast.LENGTH_SHORT).show()
            updateRecycleView()
        }
        else
        {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }

    }
    public fun update(position:Int)
    {
        var db=Dbhelper(this)
        var arr=db.retriveAll()
        var fruit=arr.get(position)

        //fetch data from particular fruit
        var id=fruit.id
        var name=fruit.fr_name
        var des=fruit.fr_des
        var price=fruit.fr_price

        //creating dialog box
        var dialog=Dialog(this)
        dialog.setContentView(R.layout.custome_dialog)

        //set dialog box value
        dialog.tvdlid.setText(id.toString())
        dialog.edtdlname.setText(name)
        dialog.edtdldes.setText(des)
        dialog.ededtdlprice.setText(price.toString())


        //handle click of update button of dialog box
        dialog.btndlupdate.setOnClickListener{

            //fetching updated value from the dialog box
            var id=dialog.tvdlid.text.toString().toInt()
            var name=dialog.edtdlname.text.toString()
            var des=dialog.edtdldes.text.toString()
            var price=dialog.ededtdlprice.text.toString().toInt()

            //pass to the fruit clas
            var fruit=fruit(id,name,des,price)

            //call update method of database pass fruit object
            var flag=db.update(fruit)
            if(flag)
            {
                Toast.makeText(this, "Recoed updated!!`", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                updateRecycleView()
            }

        }
        dialog.show()




    }

    private fun updateRecycleView() {
        //fetching data from the database
        var db=Dbhelper(this)
        var arr=db.retriveAll()
        //and pass to the adapter
        var f_adapter=FruitAdapter(this,arr)
        myrecyle.adapter=f_adapter
    }
}