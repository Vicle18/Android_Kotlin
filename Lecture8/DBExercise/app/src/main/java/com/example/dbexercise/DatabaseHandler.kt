package com.example.dbexercise

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

val DATABASE_NAME = "myDB"
val TABLE_NAME = "users"
val COL_ID = "id"
val COL_NAME = "name"
val COL_ADDRESS = "address"
val COL_AGE = "age"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_NAME + " VARCHAR(256)," +
                COL_ADDRESS + " VARCHAR(256)," +
                COL_AGE + " INTEGER)";
    db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun inserData(user:User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_ADDRESS, user.address)
        cv.put(COL_AGE, user.age)
        //cv.put(COL_ID, user.id.toString())



        val result = db.insert(TABLE_NAME, null, cv)
        if (result == -1.toLong()){
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
        }
    }


}