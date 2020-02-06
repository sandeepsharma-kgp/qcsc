package com.example.qcsc

data class EOAModel(val size: Int, val EOA: Float?) {
    override fun toString(): String {
        return "SIZE = $size    ||  EOAi = $EOA sq. cm"
    }
}