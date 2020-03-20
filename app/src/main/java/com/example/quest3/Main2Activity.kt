package com.example.quest3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {
    private var values : ArrayList<String> = ArrayList()
    private var valuesHabit : ArrayList<Habit> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (intent.getStringArrayListExtra("val") != null)
        {
            values = intent.getStringArrayListExtra("val") as ArrayList<String>
        }
        if (intent.getSerializableExtra("valHabit") != null)
        {
            valuesHabit = intent.getSerializableExtra("valHabit") as ArrayList<Habit>
        }
        if (intent.getIntExtra("result",-1) != -1)
        {
            editText.setText(valuesHabit[intent.getIntExtra("result", 0)].name)
            editText2.setText(valuesHabit[intent.getIntExtra("result", 0)].description)
            editText3.setText(valuesHabit[intent.getIntExtra("result", 0)].countOfFinish)
            editText4.setText(valuesHabit[intent.getIntExtra("result", 0)].period)
            if (valuesHabit[intent.getIntExtra("result",0)].type == "false")
            {
                radioButton2.isChecked = true
            }
            else
            {
                radioButton.isChecked = true
            }
            spinner.setSelection(valuesHabit[intent.getIntExtra("result",0)].priority)
            Log.d("INFORMATION", "RESULT NOT NULL")
        }
        button.setOnClickListener {
            if (editText.text.toString() == "") {
                val toast = Toast.makeText(
                    applicationContext,
                    "Поле не должно быть пустым",
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            } else {
                val goIntent = Intent(this, MainActivity::class.java)
                if (intent.getIntExtra("result", -1) == -1) {
                    values.add(editText.text.toString())
//            valuesHabit.add(Habit(editText.text.toString(), editText2.text.toString(), resources.getStringArray(R.array.priority)[spinner.selectedItemPosition], radioButton.isChecked.toString(), editText3.text.toString(), editText4.text.toString()))
                    valuesHabit.add(
                        Habit(
                            editText.text.toString(),
                            editText2.text.toString(),
                            spinner.selectedItemPosition,
                            radioButton.isChecked.toString(),
                            editText3.text.toString(),
                            editText4.text.toString()
                        )
                    )
                } else {
                    values[intent.getIntExtra("result", 0)] = editText.text.toString()
                    valuesHabit[intent.getIntExtra("result", 0)] = Habit(
                        editText.text.toString(),
                        editText2.text.toString(),
                        spinner.selectedItemPosition,
                        radioButton.isChecked.toString(),
                        editText3.text.toString(),
                        editText4.text.toString()
                    )
                }
                goIntent.putStringArrayListExtra("val", values)
                goIntent.putExtra("valHabit", valuesHabit)
                startActivity(goIntent)


            }
        }

        Log.d( "lifeCycle", "OnCreate")
        }

    override fun onStart() {
        super.onStart()
        Log.d( "lifeCycle", "OnStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( "lifeCycle", "OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d( "lifeCycle", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d( "lifeCycle", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d( "lifeCycle", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( "lifeCycle", "OnDestroy")
    }
}
