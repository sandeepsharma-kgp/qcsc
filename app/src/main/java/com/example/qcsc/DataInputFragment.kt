package com.example.qcsc

import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.qcsc.ui.Values
import java.math.RoundingMode
import kotlin.math.pow

class DataInputFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_data_input, container, false)
        val age: EditText = root.findViewById(R.id.age)
        val height: EditText = root.findViewById(R.id.height)
        val weight: EditText = root.findViewById(R.id.weight)
        val bsa: TextView = root.findViewById(R.id.bsa_tv)
        val ci: TextView = root.findViewById(R.id.ci_tv)
        val calculate: Button = root.findViewById(R.id.calculateButton)
        val tableButton: Button = root.findViewById(R.id.table_button)
        tableButton.visibility = View.GONE
        calculate.setOnClickListener {
            Values.weight = weight.text.toString().toInt()
            Values.age = age.text.toString().toInt()
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
            val bsaCalc =
                weight.text.toString().toFloat().pow(0.425f) * height.text.toString().toFloat().pow(
                    0.725f
                ) * 0.007184
            val newBSA = bsaCalc.toBigDecimal().setScale(1, RoundingMode.UP)
            Values.bsa = newBSA.toFloat()
            val ciAge = if (Values.age!! > 18) 2400f else 2600f
            val ciCalc = newBSA.times(ciAge.toBigDecimal())
            bsa.setText(newBSA.toString())
            ci.setText(ciCalc.toString())
            tableButton.visibility = View.VISIBLE
        }

        tableButton.setOnClickListener {
            val intent = Intent (getActivity(), PPMActivity::class.java)
            getActivity()?.startActivity(intent)
        }


        return root
    }
}