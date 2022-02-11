package com.kktua.mytasks

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kktua.mytasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val annotation = findViewById<EditText>(R.id.et_annotation)

        val preferences = AnnotationPreferences(applicationContext)
        val savedAnnotation = preferences.loadAnnotation()

        if (savedAnnotation != "")
            annotation.setText(savedAnnotation)

        binding.fab.setOnClickListener { view ->
            if (annotation.toString() == "") {
                Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show()
            } else {
                preferences.saveAnnotation(annotation.text.toString())
                Snackbar.make(view, "Anotação salva com sucesso", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}