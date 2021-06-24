package com.kotlin.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SelectDissActivity : AppCompatActivity() {

    private var exercise: Button? = null
    private var heartexercise: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_diss)

        initialise()

        exercise!!.setOnClickListener { view:View ->
            exercisedata(view
            )
        }

        heartexercise!!.setOnClickListener { view:View ->
            heartexercisedata(view
            )
        }
    }

    private fun exercisedata(view: View) {
        val intent = Intent(this@SelectDissActivity, NormalExerciseActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun heartexercisedata(view: View) {
        val intent = Intent(this@SelectDissActivity, HeartExerciseActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initialise() {
        exercise = findViewById(R.id.btn_exercise)
        heartexercise = findViewById(R.id.btn_heart_exercise)
    }
}