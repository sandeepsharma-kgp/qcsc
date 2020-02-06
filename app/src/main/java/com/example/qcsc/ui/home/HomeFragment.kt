package com.example.qcsc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.qcsc.EOAModel
import com.example.qcsc.R
import com.example.qcsc.ui.Values
import java.math.RoundingMode

class HomeFragment : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val radioGroup: RadioGroup = root.findViewById(R.id.company)
        listView = root.findViewById(R.id.list_view)

        radioGroup.setOnCheckedChangeListener { _radioGroup: RadioGroup, i: Int ->
            val radioButton: RadioButton = root.findViewById(i)
            val txt = radioButton.text
            var CompanyMap: Map<Int, Float> = when (txt) {
                "SJMRegent" -> mapOf<Int, Float>(17 to 1.30f, 19 to 1.70f, 21 to 2.00f, 23 to 2.50f)

                "SorinBicarbon" -> mapOf<Int, Float>(19 to 0.80f, 21 to 2.10f, 23 to 1.60f)

                "SJMHPMasters" -> mapOf<Int, Float>(
                    17 to 1.00f,
                    19 to 1.30f,
                    21 to 1.60f,
                    23 to 1.80f
                )

                "TTKChitraStd" -> mapOf<Int, Float>(
                    17 to 0.92f,
                    19 to 1.21f,
                    21 to 1.52f,
                    23 to 1.91f
                )

                "SJMEPIC" -> mapOf<Int, Float>(19 to 1.20f, 21 to 1.4f, 23 to 1.7f)

                "PERIMAGNA" -> mapOf<Int, Float>(19 to 1.58f, 21 to 1.9f, 23 to 2.07f, 25 to 2.33f)

                else -> mapOf<Int, Float>(19 to 1.28f, 21 to 1.69f, 23 to 1.87f, 25 to 1.89f)
            }
            val lst = CompanyMap.mapValues { Values.bsa?.let { it1 -> it.value.div(it1).toBigDecimal().setScale(2, RoundingMode.UP) } }
            val listItems = mutableListOf<EOAModel>()
            lst.forEach { listItems.add(EOAModel(it.key, it.value?.toFloat())) }
            listView.adapter =
                activity?.let {
                    ArrayAdapter(
                        it,
                        android.R.layout.simple_expandable_list_item_1,
                        listItems
                    )
                }
        }
        root.findViewById<RadioButton>(R.id.SJMRegent).isChecked = true
        return root
    }
}


