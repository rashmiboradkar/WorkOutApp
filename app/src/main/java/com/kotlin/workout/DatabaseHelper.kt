package com.kotlin.workout

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "create table  " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT," +
                    " NUMBER INTEGER, EMAIL TEXT, PASSWORD TEXT )"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }


    fun insertData(
        Name: String?,
        Email: String?,
        Number: String?,
        Password: String?
    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_2, Name) //key value pair
        cv.put(COL_3, Number)
        cv.put(COL_4, Email)
        cv.put(COL_5, Password)
        val success = db.insert(TABLE_NAME, null, cv) // true , false = -1
        return success != -1L
    }

    companion object {
        const val DATABASE_NAME = "user.db" //Database Name
        const val DATABASE_VERSION = 1 //Database version
        const val TABLE_NAME = "user" //table name
        const val COL_1 = "ID"
        const val COL_2 = "NAME"
        const val COL_3 = "NUMBER"
        const val COL_4 = "EMAIL"
        const val COL_5 = "PASSWORD"
    }
}