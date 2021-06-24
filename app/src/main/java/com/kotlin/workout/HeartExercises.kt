package com.kotlin.workout

import java.util.*

class HeartExercises {

    companion object{
        fun defaultExerciseList(): ArrayList<ExerciseModel> {
            val exercisesList = ArrayList<ExerciseModel>()

            val anjalimudra = ExerciseModel(1,
                "Anjalimudra",
                R.drawable.anjalimudra,
                false,
                false)
            exercisesList.add(anjalimudra)

            val extendedtriangle = ExerciseModel(2,
                "Extended Triangle",
                R.drawable.tumblr_inline,
                false,
                false)
            exercisesList.add(extendedtriangle)

           /* val halfmoon = ExerciseModel(3,
                "Half Moon",
                R.drawable.halfmoon,
                false,
                false)
            exercisesList.add(halfmoon)

            val parivrttatrikonasana = ExerciseModel(4,
                "Parivrtta Trikonasana",
                R.drawable.revolvedtriangle,
                false,
                false)
            exercisesList.add(parivrttatrikonasana)

            val urdhvamukhasvanasana = ExerciseModel(5,
                "Urdhva Mukha Svanasana",
                R.drawable.upward,
                false,
                false)
            exercisesList.add(urdhvamukhasvanasana)

            val savasana = ExerciseModel(6,
                "Savasana",
                R.drawable.savasanapose,
                false,
                false)
            exercisesList.add(savasana)

            val bridge = ExerciseModel(7,
                "Bridge",
                R.drawable.bridge,
                false,
                false)
            exercisesList.add(bridge)

            val chaturangadandasana = ExerciseModel(8,
                "Chaturanga Dandasana",
                R.drawable.chaturanga,
                false,
                false)
            exercisesList.add(chaturangadandasana)

            val virabhadrasana  = ExerciseModel(9,
                "Virabhadrasana ",
                R.drawable.warrior,
                false,
                false)
            exercisesList.add(virabhadrasana)

            val warrior = ExerciseModel(10,
                "Warrior",
                R.drawable.warrior1,
                false,
                false)
            exercisesList.add(warrior)

           val ustrasana = ExerciseModel(11,
                "Ustrasana",
                R.drawable.camelpose,
                false,
                false)
            exercisesList.add(ustrasana)*/
            return exercisesList
        }
    }
}