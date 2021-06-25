package com.wildwestwireless;

public class WildWestWireless {

    private double goldBaseLineCost = 49.95;
    private double goldPerLineCost = 14.50;
    private final double silverBaseLineCost = 29.95;
    private final double silverPerLineCost = 21.50;

    public Double getBill(PlanType goldPlan, int phoneLines) {
        switch (goldPlan) {
            case GOLD_PLAN:
                return goldBaseLineCost + (goldPerLineCost * (phoneLines - 1));
            case SILVER_PLAN:
                if(phoneLines > 1){
                    return silverBaseLineCost + silverPerLineCost;
                }
                return silverBaseLineCost;
            default:
                return 0.0;
        }
    }
}
