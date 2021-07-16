package com.shineprincess.workoutappp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

class Progress : AppCompatActivity() {

    private var CurrentProgress = 0
    private lateinit var progressE: ProgressBar

    private lateinit var progressHeartBar : ProgressBar
    private lateinit var  progressBreathBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        val actionbar = supportActionBar

        if (actionbar!=null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
//normal exercises
        progressE = findViewById(R.id.progressBarEX)

        CurrentProgress += 10
        progressE.max = 90
        progressE.progress = 100

        //heart exercise
        progressHeartBar = findViewById(R.id.progressBarHeart)
        CurrentProgress += 10
        progressHeartBar.max = 90
        progressHeartBar.progress = 70

        //breath exercise
        progressBreathBar = findViewById(R.id.progressBarBreath)
        CurrentProgress += 10
        progressBreathBar.max = 90
        progressBreathBar.progress = 50





    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(progressE.progress ==60 || progressE.progress ==90) progressE.incrementProgressBy(-30)
    }
}