package com.example.qcsc.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.qcsc.R
import com.example.qcsc.ui.Values

class NotificationsFragment : Fragment() {
    val wtRange: Map<IntRange, Pair<String, String>> = mapOf(
        1..5 to Pair("8 or 10", "10 or 12"),
        5..10 to Pair("12 or 14", "14 or 16"),
        10..20 to Pair("14 or 16", "16 or 18"),
        20..30 to Pair("16 or 18", "18 or 20"),
        30..40 to Pair("18 or 20", "20 or 22"),
        40..50 to Pair("20 or 22", "22 or 24"),
        50..60 to Pair("22 or 24", "24 or 26"),
        60..70 to Pair("24 or 26", "26 or 28"),
        70..80 to Pair("26 or 28", "28 or 30")
    )

    val aczRange: Map<IntProgression, Int> = mapOf(
        (100..800).step(100) to 8,
        (900..1000).step(100) to 10,
        (1100..1400).step(100) to 12,
        (1500..2200).step(100) to 16,
        (2300..3500).step(100) to 18,
        (3600..4500).step(100) to 20,
        (4600..5000).step(100) to 22,
        (5100..6000).step(100) to 24,
        (6100..7000).step(100) to 26
    )

    val ciAge = if (Values.age!! > 18) 2400f else 2600f
    val cpAge = if (Values.age!! > 18) 20 else 30


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val ciView: TextView = root.findViewById(R.id.ci_tv)
        val cdView: TextView = root.findViewById(R.id.cd_tv)
        val aczView: TextView = root.findViewById(R.id.acz_tv)
        val svcView: TextView = root.findViewById(R.id.svc_tv)
        val ivcView: TextView = root.findViewById(R.id.ivc_tv)
        val ci = Values.bsa?.times(ciAge)
        val acz = ci?.toDouble()?.let { Math.ceil(it) }
        val aczInt = acz?.toInt()
        val finalAcz = aczInt?.plus(99)?.div(100)?.times(100)
        aczRange.keys.forEach {
            run {
                if (it.contains(finalAcz)) {
                    aczView.text = aczRange.get(it).toString()
                }
            }
        }
        ciView.text = (ci).toString()
        cdView.text = (Values.weight?.times(cpAge)).toString()
        if (Values.weight!! > 80) {
            svcView.text = "30 or 32"
            ivcView.text = "32 or 34"
        } else {
            wtRange.keys.forEach {
                run {
                    if (it.contains(Values.weight!!)) {
                        svcView.text = wtRange.get(it)?.first
                        ivcView.text = wtRange.get(it)?.second
                    }
                }
            }
        }

        return root
    }
}