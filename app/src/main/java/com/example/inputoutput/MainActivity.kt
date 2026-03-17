package com.example.inputoutput

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val clickBtn = findViewById<Button>(R.id.clickBtn)
        val name = findViewById<EditText>(R.id.name)
        val world = findViewById<TextView>(R.id.world)
        clickBtn?.setOnClickListener {
            world.text = "Hello,${name.text}!"
            if (name.text.toString() == "Ben" || name.text.toString() == "Benedict") {
                world.text = "Howzit, ${name.text}!"
            } else {
                world.text = "Hello, ${name.text}!"
            }
            val swUlu = findViewById<Switch>(R.id.swUlu)
            val greeting: String = if (swUlu.isChecked) {
                "Sawubona, ${name.text}!"
            } else {
                "Hello, ${name.text}!"
            }
            world.text = greeting
            var zulu: Boolean = swUlu.isChecked
            if (zulu) {
                val greeting = "Sawubona, ${name.text}!"
            } else {
                val greeting = "Hello, ${name.text}!"
            Toast.makeText(
                this@MainActivity,
                "Button clicked", Toast.LENGTH_SHORT
            ).show()

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets
                }

            }
        }
    }
}
