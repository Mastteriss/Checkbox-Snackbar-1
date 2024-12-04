package com.example.checkboxsnackbr

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
private lateinit var editText: EditText
private lateinit var button_save: Button
private lateinit var button_exit: Button
private lateinit var textTV:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }
        textTV = findViewById(R.id.textTV)
        editText = findViewById(R.id.textEV)
        button_exit = findViewById(R.id.buttonBTN2)
        button_save = findViewById(R.id.buttonBTN1)
        button_save.setOnClickListener { view:View ->
            textTV.text = editText.text.toString()
        }
       button_exit.setOnClickListener { view:View ->
           val builder = AlertDialog.Builder(this)
           builder.setTitle("Подтвердите удаление")
           builder.setMessage("Вы действительно хотите удалить?")
           builder.setPositiveButton("Удалить"){dialog,which->
               textTV.text = ""
               Snackbar.make(view, "Данные удалены", Snackbar.LENGTH_LONG).show()
           }
           builder.setNegativeButton("Отмена"){dialog,which -> dialog.dismiss()}
           builder.show()

       }



    }


    }
