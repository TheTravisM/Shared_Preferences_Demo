package io.travis.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {


    private val PREFS_FILE: String = "io.travis.sharedpreferences.preferences"
    private val KEY_EDITTEXT: String = "key_edittext"
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var editText: EditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Variables
        editText = findViewById(R.id.editText)
        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val editTextString = sharedPreferences.getString(KEY_EDITTEXT, "")
        editText.setText(editTextString)
    }

    override fun onPause() {
        super.onPause()

        editor.putString(KEY_EDITTEXT, editText.getText().toString())
        editor.apply()
    }

}
