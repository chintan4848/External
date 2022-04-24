package com.example.myapplication1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Dbhelper(context:Context):SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION) {

    companion object{
        private var DB_NAME="fruit"
        private var DB_VERSION=1
        private var TB_NAME="FR_DETAILS"
        private var FR_NAME="FR_NAME"
        private var FR_DES="FR_DES"
        private var FR_PRICE="FR_PRICE"
        private var FR_ID="FR_ID"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $TB_NAME($FR_ID INTEGER PRIMARY KEY AUTOINCREMENT,$FR_NAME TEXT,$FR_DES TEXT,$FR_PRICE INTEGER)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insert(fruit: fruit):Boolean
    {
        var db=writableDatabase
        var cv=ContentValues()
        cv.put(FR_NAME,fruit.fr_name)
        cv.put(FR_DES,fruit.fr_des)
        cv.put(FR_PRICE,fruit.fr_price)
        var flag=db.insert(TB_NAME,null,cv)
        if(flag>0)
        {
            return true
        }
        else
        {
            return false
        }

    }

    fun retriveAll():ArrayList<fruit>
    {
        var db=readableDatabase
        var cursor=db.query(TB_NAME,null,null,null,null,null,null,null)
        var arr:ArrayList<fruit> =ArrayList()
        while(cursor.moveToNext())
        {
            var id=cursor.getInt(0)
            var name=cursor.getString(1)
            var des=cursor.getString(2)
            var price=cursor.getInt(3)
            var fruit=fruit(id,name,des,price)
            arr.add(fruit)


        }
        return arr
    }
    
    fun delete(id:Int):Boolean
    {
        var db=writableDatabase
        var flag=db.delete(TB_NAME,"$FR_ID=$id",null)
        if(flag>0)
            return true
        else
            return false
        
    }

    fun update(fruit:fruit):Boolean
    {
        var db=writableDatabase
        var cv=ContentValues()

        cv.put(FR_NAME,fruit.fr_name)
        cv.put(FR_DES,fruit.fr_des)
        cv.put(FR_PRICE,fruit.fr_price)

        //update specific row from table
       var flag=db.update(TB_NAME,cv,"$FR_ID=${fruit.id}",null)
        if(flag>0)
        {
            return true
        }
        else
        {
            return false
        }

    }


}