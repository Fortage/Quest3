package com.example.quest3

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var values  = ArrayList<String>()
    private var valuesHabit = ArrayList<Habit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingActionButton.setOnClickListener {
            val goIntent = Intent(this,Main2Activity::class.java)
            goIntent.putStringArrayListExtra("val", values)
            goIntent.putExtra("valHabit", valuesHabit)
            startActivity(goIntent)
        }

        if (intent.getStringArrayListExtra("val")!= null)
        {
            values = intent.getStringArrayListExtra("val") as ArrayList<String>
        }
        if (intent.getSerializableExtra("valHabit")!= null)
        {
            valuesHabit = intent.getSerializableExtra("valHabit") as ArrayList<Habit>
        }
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, values
        )
        Log.d( "SAVE", "Cохранил ${valuesHabit.size}")
        ListView1.adapter = adapter
        ListView1.setOnItemClickListener { parent, view, position, id ->
            val goIntent = Intent(this,Main2Activity::class.java)
            goIntent.putExtra("val", values)
            goIntent.putExtra("valHabit", valuesHabit)
            goIntent.putExtra("result", position)
            startActivity(goIntent)
        }
        Log.d( "lifeCycle", "OnCreateMain")

    }

    override fun onStart() {
        super.onStart()
        Log.d( "lifeCycle", "OnStartMain")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( "lifeCycle", "OnRestartMain")
    }

    override fun onResume() {
        super.onResume()
        Log.d( "lifeCycle", "OnResumeMain")
    }

    override fun onPause() {
        super.onPause()
        Log.d( "lifeCycle", "OnPauseMain")
    }

    override fun onStop() {
        super.onStop()
        Log.d( "lifeCycle", "OnStopMain")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( "lifeCycle", "OnDestroyMain")
    }

}
