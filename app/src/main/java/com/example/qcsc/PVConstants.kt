package com.example.qcsc

import com.example.qcsc.ui.Values

object PVConstants {
    val PVA : Any = when (Values.weight) {
        1 -> 4
        2 -> 5
        3 -> 6
        4 -> 7
        5 -> 7.5
        6 -> 8
        7 -> 9
        8 -> 9.5
        9 -> 10
        10,11 -> 11
        12,13 -> 12
        14,15 -> 13
        16,17 -> 13.5
        18,19 -> 14
        in 20..24 -> 15
        in 25..29 -> 17
        in 30..34 -> 18.5
        else -> 20
    }

    val PVH : Any = when(Values.weight) {
        1 -> 0
        2 -> 0
        3 -> 4
        4 -> 5
        5 -> 5.5
        6 -> 6
        7,8 -> 6.5
        9 -> 7
        10,11 -> 7.5
        12,13 -> 8.5
        14,15 -> 9
        16,17 -> 9.5
        18,19 -> 10
        in 20..24 -> 11
        in 25..29 -> 12
        in 30..34 -> 13
        else -> 14
    }
}