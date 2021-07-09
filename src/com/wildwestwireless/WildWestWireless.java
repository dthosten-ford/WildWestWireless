package com.wildwestwireless;

public class WildWestWireless {

    private final double goldBaseLineCost = 49.95;
    private final double goldPerLineCost = 14.50;
    private final double silverBaseLineCost = 29.95;
    private final double silverPerLineCost = 21.50;

    public Double getBill(PlanType planType, int phoneLines) {
        if (phoneLines < 1) return 0.0;
        switch (planType) {
            case GOLD_PLAN:
                return calculatePlan(phoneLines, goldBaseLineCost, goldPerLineCost);
            case SILVER_PLAN:
                return calculatePlan(phoneLines, silverBaseLineCost, silverPerLineCost);
            default:
                return 0.0;
        }
    }

    private Double calculatePlan(int phoneLines, double baseLineCost, double perLineCost) {
        return baseLineCost + (perLineCost * (phoneLines - 1));
    }
}
