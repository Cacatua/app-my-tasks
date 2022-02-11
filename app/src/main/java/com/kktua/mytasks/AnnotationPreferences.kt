package com.kktua.mytasks

import android.content.Context
import android.content.SharedPreferences

class AnnotationPreferences(c: Context) {
    private val context: Context = c
    private val preferences: SharedPreferences = context.getSharedPreferences(FILE_NAME, 0)
    private val editor: SharedPreferences.Editor? = preferences.edit()

    private companion object {
        const val FILE_NAME = "annotation.preferences"
        const val KEY_NAME = "name"
    }

    fun saveAnnotation(annotation: String) {
        editor?.putString(KEY_NAME, annotation)
        editor?.commit()
    }

    fun loadAnnotation() = preferences.getString(KEY_NAME, "").toString()
}