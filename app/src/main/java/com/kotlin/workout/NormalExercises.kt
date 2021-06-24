package com.kotlin.workout

class NormalExercises {

    companion object{
        fun defaultExerciseList():ArrayList<ExerciseModel>{
            val exercisesList = ArrayList<ExerciseModel>()

            val jumpingJacks = ExerciseModel(1,
                "Jumping Jacks",
                R.drawable.jumping_jacks,
                false,
                false)
            exercisesList.add(jumpingJacks)

            val wallSit = ExerciseModel(2,
                "Wall Sit",
                R.drawable.wall_sit,
                false,
                false)
            exercisesList.add(wallSit)

            val wallpushUp = ExerciseModel(3,
                "Wall Push Ups",
                R.drawable.wall_push_up,
                false,
                false)
            exercisesList.add(wallpushUp)

            val abCrunch = ExerciseModel(4,
                "Abdominal Crunch",
                R.drawable.ab_crunch,
                false,
                false)
            exercisesList.add(abCrunch)

            val stepUp = ExerciseModel(5,
                "Step-Up Onto Chair",
                R.drawable.step_up,
                false,
                false)
            exercisesList.add(stepUp)

            val squat = ExerciseModel(6,
                "Squat",
                R.drawable.squats,
                false,
                false)
            exercisesList.add(squat)

            val curtsylunges = ExerciseModel(7,
                "Curtsy Lunges",
                R.drawable.curtsy_lunges,
                false,
                false)
            exercisesList.add(curtsylunges)

            val laterallunges = ExerciseModel(8,
                "Lateral Lunges",
                R.drawable.lateral_lunges,
                false,
                false)
            exercisesList.add(laterallunges)

            val splitjumps = ExerciseModel(9,
                "Split Jumps",
                R.drawable.split_jumps,
                false,
                false)
            exercisesList.add(splitjumps)

            val lunge = ExerciseModel(10,
                "Lunges",
                R.drawable.lunges,
                false,
                false)
            exercisesList.add(lunge)

            val crossbodypushup = ExerciseModel(11,
                "Cross Body Push Up",
                R.drawable.cross_body_push_up,
                false,
                false)
            exercisesList.add(crossbodypushup)

            val Plank = ExerciseModel(12,
                "Plank",
                R.drawable.plank,
                false,
                false)
            exercisesList.add(Plank)

            return exercisesList
        }
    }
}