package com.example.campsitecommander

import android.R.attr.category
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeScreen : AppCompatActivity() {

    //Declaration
    private lateinit var tvTitle: TextView
    private lateinit var spinner : Spinner
    private lateinit var edtItem : EditText
    private lateinit var edtQuantity : EditText
    private lateinit var edtComments : EditText
    private lateinit var tvTotal : TextView
    private lateinit var btnAdd : Button
    private lateinit var btnList : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)

        //Typecasting
        tvTitle= findViewById(R.id.tvTitle)
        spinner =findViewById(R.id.Spinner)
        edtItem = findViewById(R.id.edtItem)
        edtQuantity= findViewById(R.id.edtQuantity)
        edtComments = findViewById(R.id.edtComments)
        tvTotal = findViewById(R.id.tvTotal)
        btnAdd = findViewById(R.id.btnAdd)
        btnList= findViewById(R.id.btnList)


        // updated total items
        GearData.toItemPacked()
        tvTotal().toString()

        //Create spinner adapter for the category
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,category)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        //Add gears wanted
        btnAdd.setOnClickListener {
            addGear()
        }

        btnList.setOnClickListener {
            startActivity(this,
                DetailActivity::class.java)

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun tvTotal(){

        //Gets the selected items in spinner
        spinner.selectedItemPosition

        val item = edtItem.text.toString()
        val quantity = edtQuantity.text.toString()
        val comment = edtComments.text.toString()

        //error handling to make sure all input fields are completed
        if(item.isEmpty() || quantity.isEmpty() || comment.isEmpty()){
            Toast.makeText(this,"Please complete all the fields!",Toast.LENGTH_SHORT).show()
            return
        }
        val quantity = quantity.toIntOrNull()


    }
    private fun addGear(){
        val category = category.text.toString.trim()
        val item = edtItem.text.toString().trim()
        val quantity = edtQuantity.text.toString().trim()
        edtComments.text.toString().trim()

        //error handling
        if(item.isEmpty() || category.isEmpty()){
            Toast.makeText(this,"Please enter item, Category and item!", Toast.LENGTH_SHORT).show()
            return
        }
        //Ensure Quantity is a valid numeric values
        if(quantity >= 0) {
            Toast.makeText(this,"Quantity must be a positive numeric value", Toast.LENGTH_SHORT).show()
            return



        }





    }


}