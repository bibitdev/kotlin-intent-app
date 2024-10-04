package com.bibitdev.myintentapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveWithObjectActivity : AppCompatActivity() {
    // 2. buat companion
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move_with_object)

        // 1
        val tvObject: TextView = findViewById(R.id.tv_object_received)

        // 3. get Parcelable
        val  person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val data = "Name : {${person.name.toString()}, \nEmail : ${person.email}, \nAge ${person.age}, \nLocation : ${person.city}"
            tvObject.text = data
        }
    }
}