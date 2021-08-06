package com.wildwestwireless

data class PlanDetail(
    val phoneLines: Int,
    var baseLineCost: Double,
    val perLineCost: Double,
    val minutesUsed: Double
)
