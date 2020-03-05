package com.example.qcsc.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.qcsc.EOAModel
import com.example.qcsc.PVConstants
import com.example.qcsc.PVConstants.PVA
import com.example.qcsc.R
import com.example.qcsc.ui.Values
import com.google.api.services.sheets.v4.Sheets
import org.json.JSONObject
import java.io.IOException
import java.time.temporal.ValueRange


class DashboardFragment : Fragment() {

    private var result: com.google.api.services.sheets.v4.model.ValueRange? = null
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var pva: TextView
    private lateinit var pvh: TextView
    private lateinit var zScore: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        pva = root.findViewById(R.id.pva_tv)
        pvh = root.findViewById(R.id.pvh_tv)
        zScore = root.findViewById(R.id.zscore_tv)

        pva.text = PVConstants.PVA.toString()
        pvh.text = PVConstants.PVH.toString()
        val json = JSONObject("/src/com/example/qcsc/assets/PVA.json")
        return root
    }
}