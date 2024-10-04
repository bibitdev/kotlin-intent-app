package com.bibitdev.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // INISIALISASI

        // button pindah activity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        // button pindah activity dengan data
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        // button pindah activity dengan objek
        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        // button implicit intent
        val btnDialPhone : Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                // putExtra
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Raikhan")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 12)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Bibit Raikhan Azzaki",
                    12,
                    "bibitraikhanazzaki@gmail.com",
                    "Banjarnegara"
                )

                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081918842763"
                val dialNumberPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel : ${phoneNumber}"))
                startActivity(dialNumberPhone)
            }
        }
    }
}