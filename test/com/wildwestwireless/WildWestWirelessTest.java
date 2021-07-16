// ***************************************************************************
// Copyright (c) 2020, Industrial Logic, Inc., All Rights Reserved.
//
// This code is the exclusive property of Industrial Logic, Inc. It may ONLY be
// used by students during Industrial Logic's workshops or by individuals
// who are being coached by Industrial Logic on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Industrial Logic, Inc.
// ****************************************************************************

package com.wildwestwireless;

import org.junit.Before;
import org.junit.Test;

import static com.wildwestwireless.PlanType.GOLD_PLAN;
import static com.wildwestwireless.PlanType.SILVER_PLAN;
import static org.junit.Assert.assertEquals;

public class WildWestWirelessTest {
    private WildWestWireless subject;

    @Before
    public void setUp() {
        subject = new WildWestWireless();
    }

    @Test
    public void getBill_goldPlan_oneLine() {
        assertEquals(49.95, subject.getBill(GOLD_PLAN, 1, 1), 0.0);
    }

    @Test
    public void getBill_goldPlan_twoLines() {
        assertEquals(64.45, subject.getBill(GOLD_PLAN, 2, 1), 0.0);
    }

    @Test
    public void getBill_goldPlan_threeLines() {
        assertEquals(78.95, subject.getBill(GOLD_PLAN, 3, 1), 0.0);
    }

    @Test
    public void getBill_silverPlan_oneLine() {
        assertEquals(29.95, subject.getBill(SILVER_PLAN, 1, 1), 0.0);
    }

    @Test
    public void getBill_silverPlan_twoLines() {
        assertEquals(51.45, subject.getBill(SILVER_PLAN, 2, 1), 0.0);
    }

    @Test
    public void getBill_silverPlan_threeLines() {
        assertEquals(72.95, subject.getBill(SILVER_PLAN, 3, 1), 0.0);
    }

    @Test
    public void getBill_hasPositiveLines() {
        assertEquals(0.0, subject.getBill(SILVER_PLAN, 0, 1), 0.0);
        assertEquals(0.0, subject.getBill(SILVER_PLAN, -1, 1), 0.0);
        assertEquals(0.0, subject.getBill(SILVER_PLAN, -42, 1), 0.0);
        assertEquals(0.0, subject.getBill(GOLD_PLAN, 0, 1), 0.0);
        assertEquals(0.0, subject.getBill(GOLD_PLAN, -1, 1), 0.0);
        assertEquals(0.0, subject.getBill(GOLD_PLAN, -42, 1), 0.0);
    }

    @Test
    public void getBill_hasExcessMinutes() {
        assertEquals(50.40, subject.getBill(GOLD_PLAN, 1, 1001), 0.01);
        assertEquals(49.95, subject.getBill(GOLD_PLAN, 1, 999), 0.01);
        assertEquals(49.95, subject.getBill(GOLD_PLAN, 1, 1000), 0.01);
        assertEquals(54.45, subject.getBill(GOLD_PLAN, 1, 1010), 0.01);
        assertEquals(40.75, subject.getBill(SILVER_PLAN, 1, 520), 0.00);
        assertEquals(29.95, subject.getBill(SILVER_PLAN, 1, 499), 0.00);
        assertEquals(29.95, subject.getBill(SILVER_PLAN, 1, 500), 0.00);
    }
}
