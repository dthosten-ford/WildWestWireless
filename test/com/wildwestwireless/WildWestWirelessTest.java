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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WildWestWirelessTest {

    @Test
    public void goldPlan_oneLine() {
        WildWestWireless subject = new WildWestWireless();

        assertEquals(49.95, subject.getBill(), 0.0);
    }

    @Test
    public void goldPlan_twoLines() {
        WildWestWireless subject = new WildWestWireless();

        assertEquals(64.45, subject.getBill(), 0.0);
    }
}
