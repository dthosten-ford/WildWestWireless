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

import static org.junit.Assert.assertEquals;

public class WildWestWirelessTest {
    private WildWestWireless subject;

    //TODO Test for zero or fewer lines
    //TODO add goldBill in tests

    @Before
    public void setUp() {
        subject = new WildWestWireless();
    }

    @Test
    public void getBill_goldPlan_oneLine() {
        assertEquals(49.95, subject.getBill(PlanType.GOLD_PLAN, 1), 0.0);
    }

    @Test
    public void getBill_goldPlan_twoLines() {
        assertEquals(64.45, subject.getBill(PlanType.GOLD_PLAN, 2), 0.0);
    }

    @Test
    public void getBill_goldPlan_threeLines() {
        assertEquals(78.95, subject.getBill(PlanType.GOLD_PLAN, 3), 0.0);
    }

    @Test
    public void getBill_silverPlan_oneLine() {
        assertEquals(29.95, subject.getBill(PlanType.SILVER_PLAN, 1), 0.0);
    }

    @Test
    public void getBill_silverPlan_twoLines() {
        assertEquals(51.45, subject.getBill(PlanType.SILVER_PLAN, 2), 0.0);
    }
}
