package com.wildwestwireless;

public class WildWestWireless {

    private double goldBaseLineCost = 49.95;
    private double goldPerLineCost = 14.50;

    public Double getBill(PlanType goldPlan, int phoneLines) {
        return goldBaseLineCost + (goldPerLineCost * (phoneLines - 1));
    }
}
