package com.mikucode.dobcalculatorapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration.Companion.minutes

class MainActivity : AppCompatActivity() {
    val textDOB = findViewById<TextView>(R.id.dateNum)
    val textDOBinMin = findViewById<TextView>(R.id.dateNumMin)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dateBtn = findViewById<Button>(R.id.datePickerBtn)
        dateBtn.setOnClickListener{
             onDateBtnClicked()
        }
    }
    private fun onDateBtnClicked() {

        val myCalendar= Calendar.getInstance()
        var year = myCalendar.get(Calendar.YEAR)
        var month= myCalendar.get(Calendar.MONTH)
        var day=myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
            { _, selectedYear, selectedMonth, dayOfMonth ->
                val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH )
                val selectedDate= "$dayOfMonth/${selectedMonth+1}/$selectedYear"
                val formattedDate= sdf.parse(selectedDate)
                val selectedDateInMin = formattedDate.time / 60000 //this time() function returns how many milliseconds passed from jan 1:1970: it's divided by 6000 to convert to minutes
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val DOBinMin = currentDate.time / 60000 - selectedDateInMin

                textDOB.text = selectedDate
                textDOBinMin.text = DOBinMin.toString()
                textDOBinMin.text = "$DOBinMin"

            },year,month,day).show()





    }


}