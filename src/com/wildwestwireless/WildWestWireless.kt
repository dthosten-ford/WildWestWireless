package com.wildwestwireless

class WildWestWireless {

    fun getBill(planType: PlanType, phoneLines: Int, minutesUsed: Int): Double {
        val planCosts = PlanCost()
        planCosts.baseLineCost = when (planType) {
            PlanType.GOLD_PLAN -> GOLD_BASE_LINE_COST
            else -> SILVER_BASE_LINE_COST
        }
        planCosts.perLineCost = when (planType) {
            PlanType.GOLD_PLAN -> GOLD_PER_LINE_COST
            else -> SILVER_PER_LINE_COST
        }
        return if (phoneLines < 1) ZERO_COST else {
            calculatePlanDetails(
                phoneLines,
                minutesUsed,
                planCosts,
                planType
            )
        }
    }

    private fun calculatePlanDetails(
        phoneLines: Int,
        minutesUsed: Int,
        planCost: PlanCost,
        planType: PlanType
    ): Double {
        return calculatePlan(
            PlanDetail(
                phoneLines = phoneLines,
                baseLineCost = planCost.baseLineCost,
                perLineCost = planCost.perLineCost,
                minutesUsed = minutesUsed.toDouble(),
                planType = planType
            )
        )
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
        planDetail: PlanDetail
    ): Double {
        return planDetail.baseLineCost + planDetail.perLineCost * (planDetail.phoneLines - 1) + getRateForPlan(
            planDetail.planType,
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