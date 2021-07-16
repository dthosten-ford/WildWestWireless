package com.wildwestwireless;

import static com.wildwestwireless.PlanType.GOLD_PLAN;
import static com.wildwestwireless.PlanType.SILVER_PLAN;

public class WildWestWireless {

    private static final double GOLD_BASE_LINE_COST = 49.95;
    private static final double GOLD_PER_LINE_COST = 14.50;
    private static final double SILVER_BASE_LINE_COST = 29.95;
    private static final double SILVER_PER_LINE_COST = 21.50;
    private static final double GOLD_INCLUDED_MINUTES = 1000.0;
    private static final double SILVER_INCLUDED_MINUTES = 500.0;
    private static final double GOLD_MINUTES_RATE = 0.45;
    private static final double SILVER_MINUTES_RATE = 0.54;

    public Double getBill(PlanType planType, int phoneLines, int minutesUsed) {
        if (phoneLines < 1) return 0.0;
        switch (planType) {
            case GOLD_PLAN:
                return calculatePlan(phoneLines, GOLD_BASE_LINE_COST, GOLD_PER_LINE_COST, minutesUsed, GOLD_PLAN);
            case SILVER_PLAN:
                return calculatePlan(phoneLines, SILVER_BASE_LINE_COST, SILVER_PER_LINE_COST, minutesUsed, SILVER_PLAN);
            default:
                return 0.0;
        }
    }

    private double getRateForPlan(PlanType planType, double minutesUsed) {
        if (planType.equals(GOLD_PLAN))
            return GOLD_MINUTES_RATE * Math.max((minutesUsed - GOLD_INCLUDED_MINUTES), 0);
        else
            return SILVER_MINUTES_RATE * Math.max((minutesUsed - SILVER_INCLUDED_MINUTES), 0);
    }

    private Double calculatePlan(int phoneLines, double baseLineCost, double perLineCost, double minutesUsed, PlanType planType) {
        return baseLineCost + (perLineCost * (phoneLines - 1)) + getRateForPlan(planType, minutesUsed);
    }
}