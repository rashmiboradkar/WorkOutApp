package com.kotlin.workout

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    var etFName: EditText? = null
    var etEmail: EditText? = null
    var etNumber: EditText? = null
    var etPassword: EditText? = null
    var etcpassword: EditText? = null

    var gologin: Button? = null
    var registration: Button? = null

    var name: String? = null
    var email:String? = null
    var number:String? = null
    var password:String? = null
    var cpassword:String? = null


    var database: SQLiteDatabase? = null
    var helper: DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initialise()
        helper = DatabaseHelper(this)

        registration!!.setOnClickListener { view: View ->
            registerData(view
            )
        }

        gologin!!.setOnClickListener { view: View ->
            loginScreen(view
            )
        }
    }

    private fun loginScreen(view: View) {
        val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun registerData(view: View) {
        name = etFName!!.text.toString()
        email = etEmail!!.text.toString()
        number = etNumber!!.text.toString()
        password = etPassword!!.text.toString()
        cpassword = etcpassword!!.text.toString()

        if (name!!.isEmpty()) {
            etFName!!.error = "Name is Required"
            etFName!!.requestFocus()
            return
        }

        if (email!!.isEmpty()) {
            etEmail!!.error = "Email is Required"
            etEmail!!.requestFocus()
            return
        }

        if (number!!.isEmpty()) {
            etNumber!!.error = "Mobile Number is Required"
            etNumber!!.requestFocus()
            return
        }

        if (password!!.isEmpty()) {
            etPassword!!.error = "Password is Required"
            etPassword!!.requestFocus()
            return
        }

        if (password!!.length < 8) {
            etPassword!!.error = "Atleast 8 character required"
            etPassword!!.requestFocus()
            return
        }

        if (cpassword!!.isEmpty()) {
            etcpassword!!.error = "Password is Required"
            etcpassword!!.requestFocus()
            return
        }

        if (cpassword!!.length < 8) {
            etcpassword!!.error = "Atleast 8 character required"
            etcpassword!!.requestFocus()
            return
        }

        if (isRegistration(email!!) == "EMAIL EXISTS") {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Email Already Exisit")
            builder.setMessage("The Email Already Register ")
            builder.setCancelable(true)
            builder.setPositiveButton("Ok") { dialog, which -> dialog.dismiss() }
            builder.show()
        }

        if (isRegistration(email!!) == "NOT EXISTS") {
            val isInserted = helper!!.insertData(name!!, email!!, number!!, password!!)
            if (isInserted == true) {
                Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isRegistration(email: String): String {
        database = helper!!.readableDatabase

        val myEmail = DatabaseHelper.COL_4+ "=?"
        val cursor = database!!.query(DatabaseHelper.TABLE_NAME, null, myEmail, arrayOf(email), null, null, null)

        if (cursor.count < 1) {
            cursor.close()
            return "NOT EXISTS"
        }

        cursor.close()
        return "EMAIL EXISTS"
    }

    private fun initialise() {
        etFName = findViewById(R.id.etRegName)
        etNumber = findViewById(R.id.etRegPhone)
        etEmail = findViewById(R.id.etRegGmail)
        etPassword = findViewById(R.id.etRegPassword)
        etcpassword = findViewById(R.id.etRegConformPassword)

        registration = findViewById(R.id.btnRegistration)
        gologin= findViewById<Button>(R.id.btnGotoLogin)
    }
}
