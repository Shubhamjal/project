package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var btn:Button?=null//var declaration
    var editText:EditText?=null
    var editText1 : EditText? = null
    var editText2 : EditText? = null
    var editText3 : EditText? = null
    var editText4 : EditText? = null
    var editText5 : EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show()

        btn=findViewById(R.id.button)
        editText=findViewById(R.id.editTextText)
        editText1=findViewById(R.id.editTextPhone)
        editText2=findViewById(R.id.editTextTextEmailAddress2)
        editText3=findViewById(R.id.editTextText3)
        editText4=findViewById(R.id.editTextNumberPassword)
        editText5=findViewById(R.id.editTextNumberPassword2)


        btn?.setOnClickListener {
            if (editText?.text.toString().isNullOrEmpty()
                ||editText1?.text.toString().isNullOrEmpty()
                ||editText2?.text.toString().isNullOrEmpty()
                ||editText3?.text.toString().isNullOrEmpty()
                ||editText4?.text.toString().isNullOrEmpty()
                ||editText5?.text.toString().isNullOrEmpty()
                ){
                Toast.makeText(this, "Enter Details",Toast.LENGTH_SHORT).show()
               if (editText?.text.toString().isNullOrEmpty()){
                   editText?.error="Enter Name"
               }
                if (editText1?.text.toString().isNullOrEmpty()){
                    editText1?.error="Enter Contact"
                }
                if (editText2?.text.toString().isNullOrEmpty()){
                    editText2?.error="Enter Email ID"
                }
                if (editText3?.text.toString().isNullOrEmpty()){
                    editText3?.error="Enter Address"
                }
                else if(editText5?.text.toString()!=editText4?.text.toString()){
                    editText5.error="Wrong Password"
                }

            }else{

                var intent=Intent(this,SecondActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, editText?.text.toString(),Toast.LENGTH_SHORT).show()
            }



        }
    }
}
