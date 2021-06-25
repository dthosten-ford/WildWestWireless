package com.wildwestwireless;

public class WildWestWireless {

    public Double getBill(int phoneLines) {
        return 49.95 + (14.50 * (phoneLines - 1));
    }
}
