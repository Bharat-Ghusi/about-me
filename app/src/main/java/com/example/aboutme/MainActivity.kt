package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import com.example.aboutme.ui.theme.AboutMeTheme

class MainActivity : ComponentActivity() {
   private lateinit var bindings: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this,R.layout.activity_main)
        bindings.doneBtn.setOnClickListener { addName(it) }
    }

    //Method to add name
    private fun addName(view: View) {

       bindings.apply {
           nameText.text = nameEditText.text
           nameText.visibility = View.VISIBLE
           view.visibility = View.GONE
           nameEditText.visibility = View.GONE
       }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}

