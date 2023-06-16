package my.packlol.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity : AppCompatActivity() {

    var tvSelectedDate : TextView? = null
    var tvAgeInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btndate : Button = findViewById(R.id.datebutton)
        tvSelectedDate = findViewById(R.id.showdate)
        tvAgeInMinutes = findViewById(R.id.showminutes)
        btndate.setOnClickListener{
            clickDatePicker()
        }

    }
//hi
    fun clickDatePicker(){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            Toast.makeText(this, "Date picker works", Toast.LENGTH_LONG).show()

            val selectedDate = "$day/${month}/$year"
            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate.time/60000

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDataInMinutes = currentDate.time / 60000
            val differenceInMinutes = currentDataInMinutes - selectedDateInMinutes

            tvAgeInMinutes?.text = differenceInMinutes.toString()
        },
            year, month, day).show()

    }

}