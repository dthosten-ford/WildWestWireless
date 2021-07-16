package com.wildwestwireless;

import static com.wildwestwireless.PlanType.GOLD_PLAN;
import static com.wildwestwireless.PlanType.SILVER_PLAN;

public class WildWestWireless {

    private final double goldBaseLineCost = 49.95;
    private final double goldPerLineCost = 14.50;
    private final double silverBaseLineCost = 29.95;
    private final double silverPerLineCost = 21.50;
    private final double goldIncludedMinutes = 1000.0;
    private final double silverIncludedMinutes = 500.0;

    public Double getBill(PlanType planType, int phoneLines, int minutesUsed) {
        if (phoneLines < 1) return 0.0;
        switch (planType) {
            case GOLD_PLAN:
                return calculatePlan(phoneLines, goldBaseLineCost, goldPerLineCost, minutesUsed, GOLD_PLAN);
            case SILVER_PLAN:
                return calculatePlan(phoneLines, silverBaseLineCost, silverPerLineCost, minutesUsed, SILVER_PLAN);
            default:
                return 0.0;
        }
    }

    private double getRateForPlan(PlanType planType, double minutesUsed) {
        if (planType.equals(GOLD_PLAN))
            return 0.45 * Math.max((minutesUsed - goldIncludedMinutes), 0);
        else
            return 0.54 * Math.max((minutesUsed - silverIncludedMinutes), 0);
    }

    private Double calculatePlan(int phoneLines, double baseLineCost, double perLineCost, double minutesUsed, PlanType planType) {
        if (planType.equals(GOLD_PLAN))
            return baseLineCost + (perLineCost * (phoneLines - 1)) + getRateForPlan(GOLD_PLAN, minutesUsed);
        else
            return baseLineCost + (perLineCost * (phoneLines - 1)) + getRateForPlan(SILVER_PLAN, minutesUsed);
    }
}
