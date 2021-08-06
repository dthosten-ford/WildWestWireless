package com.wildwestwireless

class WildWestWireless {

    fun getBill(planType: PlanType?, phoneLines: Int, minutesUsed: Int): Double {
        // TODO decide what to put in PlanDetails

        return if (phoneLines < 1) ZERO_COST else when (planType) {
            PlanType.GOLD_PLAN -> calculatePlan(
                PlanType.GOLD_PLAN,
                PlanDetail(
                    phoneLines = phoneLines,
                    baseLineCost = GOLD_BASE_LINE_COST,
                    perLineCost = GOLD_PER_LINE_COST,
                    minutesUsed =  minutesUsed.toDouble()
                )
            )
            PlanType.SILVER_PLAN -> {
                calculatePlan(
                    PlanType.SILVER_PLAN,
                    PlanDetail(
                        phoneLines = phoneLines,
                        baseLineCost = SILVER_BASE_LINE_COST,
                        perLineCost = SILVER_PER_LINE_COST,
                        minutesUsed = minutesUsed.toDouble()
                    )
                )
            }
            else -> 0.0
        }
    }

    private fun getRateForPlan(planType: PlanType, minutesUsed: Double): Double {
        return if (planType == PlanType.GOLD_PLAN) GOLD_MINUTES_RATE * Math.max(
            minutesUsed - GOLD_INCLUDED_MINUTES,
            ZERO_COST
        )
        else
            SILVER_MINUTES_RATE * Math.max(minutesUsed - SILVER_INCLUDED_MINUTES, ZERO_COST)
    }

    private fun calculatePlan(
        planType: PlanType,
        planDetail: PlanDetail
    ): Double {
        return planDetail.baseLineCost + planDetail.perLineCost * (planDetail.phoneLines - 1) + getRateForPlan(
            planType,
            planDetail.minutesUsed
        )
    }

    companion object {
        // TODO: introduce account object to contain base cost...
//        private val plansMap = mapOf{ (PlanType.GOLD_PLAN, ) }
        private const val GOLD_BASE_LINE_COST = 49.95
        private const val GOLD_PER_LINE_COST = 14.50
        private const val SILVER_BASE_LINE_COST = 29.95
        private const val SILVER_PER_LINE_COST = 21.50
        private const val GOLD_INCLUDED_MINUTES = 1000.0
        private const val SILVER_INCLUDED_MINUTES = 500.0
        private const val GOLD_MINUTES_RATE = 0.45
        private const val SILVER_MINUTES_RATE = 0.54
        private const val ZERO_COST = 0.0
    }
}