package com.wildwestwireless;

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
                return calculatePlan(phoneLines, goldBaseLineCost, goldPerLineCost, minutesUsed);
            case SILVER_PLAN:
                return calculatePlan(phoneLines, silverBaseLineCost, silverPerLineCost, minutesUsed);
            default:
                return 0.0;
        }
    }

    private double getRateForPlan(PlanType planType, double minutesUsed){
        return 0.45 * Math.max((minutesUsed - goldIncludedMinutes), 0);
    }

    private Double calculatePlan(int phoneLines, double baseLineCost, double perLineCost, double minutesUsed) {
        return baseLineCost + (perLineCost * (phoneLines - 1)) + getRateForPlan(PlanType.GOLD_PLAN, minutesUsed);
    }
}
