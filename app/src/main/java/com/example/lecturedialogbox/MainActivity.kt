package com.example.lecturedialogbox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lecturedialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.button1.setOnClickListener {
        val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)


            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when yes is clicked?
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                // what action should be performed when no is clicked?
            })
                builder1.show()

        }

        binding.button2.setOnClickListener {
            val options = arrayOf("gulab","kajukatli", "rasmalai")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("which is your favourite mithai?")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialog, which ->
               // what action should be performed when user clicks on any item?
                Toast.makeText(this, "this is your ${options[which]}", Toast.LENGTH_LONG).show()
            })
            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.setNegativeButton("decline", DialogInterface.OnClickListener { dialog, which ->

            })
                builder2.show()

        }

            binding.button3.setOnClickListener {
                val options = arrayOf("gulab","kajukatli", "rasmalai")
                val builder2 = AlertDialog.Builder(this)
                builder2.setTitle("which is your favourite mithai?")
                builder2.setMultiChoiceItems(options, null , DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    Toast.makeText(this, "you clicked ${options[which]}", Toast.LENGTH_SHORT).show()
                })
                builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->

                })
                builder2.setNegativeButton("decline", DialogInterface.OnClickListener { dialog, which ->

                })
                builder2.show() 
            }
    }
}