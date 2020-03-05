package com.example.qcsc.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.api.services.sheets.v4.Sheets
import java.io.IOException
import java.time.temporal.ValueRange

class DashboardViewModel : ViewModel() {
    private lateinit var service: Sheets
    private var result: com.google.api.services.sheets.v4.model.ValueRange? = null

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}