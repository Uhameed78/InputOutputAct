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
    @SuppressLint("SetTextI18n", "UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val clickBtn = findViewById<Button>(R.id.clickBtn)
        val name = findViewById<EditText>(R.id.name)
        val world = findViewById<TextView>(R.id.world)
        val gWitch = findViewById<Switch>(R.id.gWitch) // move outside the click listener

        clickBtn.setOnClickListener {
            val nameText = name.text.toString()

            world.text = when {
                gWitch.isChecked -> "Guten Tag, $nameText!"
                nameText == "Ben" || nameText == "Benedict" -> "Howzit, $nameText!"
                nameText =="Adolf" ||  nameText =="Adolf Hitler" -> "Sieg Heil, $nameText!"
                else -> "Hello, $nameText!"
            }

            Toast.makeText(this@MainActivity, "Button clicked", Toast.LENGTH_SHORT).show()
        }
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

