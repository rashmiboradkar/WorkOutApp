package com.kotlin.workout

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var etemail: EditText? = null
    private var etpass: EditText? = null

    private var email: String? = null
    private var pass: String? = null

    private var login: Button? = null
    private var registration: TextView? = null

    var database: SQLiteDatabase? = null
    var helper: DatabaseHelper? = null

   /* private var cursor: Cursor? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        helper= DatabaseHelper(this)
        database = helper!!.readableDatabase

        initialise()

        login!!.setOnClickListener { view: View ->
            logindata(view
            )
        }
        registration!!.setOnClickListener { view: View ->
            register(view
            )
        }
    }

    private fun logindata(view: View) {

        helper = DatabaseHelper(this)
        email = etemail!!.text.toString()
        pass = etpass!!.text.toString()

        if (email!!.isEmpty()) {
            etemail!!.error = "Email is Required"
            etemail!!.requestFocus()
            return
        }
        if (pass!!.isEmpty()) {
            etpass!!.error = "Password is Required"
            etpass!!.requestFocus()
            return
        }
        if (pass!!.length < 8) {
            etpass!!.error = "Atleast 8 character required"
            etpass!!.requestFocus()
            return
        }
        val storedPassword = getSingleEntry(email!!)
        if (email != "" && pass != "") {
            if (pass == storedPassword) {

                val editor = getSharedPreferences(MY_LOGIN_PREFS, MODE_PRIVATE).edit()
                editor.putString(USER_EMAIL, email)
                editor.putString(USER_PASSWORD, pass)
                editor.apply()

                val intent = Intent(this@LoginActivity, StartExercise::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Email & Password dont match", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSingleEntry(email: String): String {
        database = helper!!.readableDatabase
        val myEmail = DatabaseHelper.COL_4 + "=?"
        val cursor =
            database!!.query(DatabaseHelper.TABLE_NAME, null, myEmail, arrayOf(email), null, null, null)
        if (cursor.count < 1) {
            cursor.close()
            return "EMAIL NOT EXISTS"
        }
        cursor.moveToFirst()
        val password = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_5))
        cursor.close()
        return password
    }

    private fun register(view: View) {
        val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
        startActivity(intent)
    }

    private fun initialise() {
        registration = findViewById(R.id.tvRegister)
        login = findViewById(R.id.btnLogin)
        etemail = findViewById(R.id.etLogGmail)
        etpass = findViewById(R.id.etLoginPassword)
    }

    companion object {
        const val MY_LOGIN_PREFS = "login"
        const val USER_EMAIL = "email"
        const val USER_PASSWORD = "pass"
    }
}