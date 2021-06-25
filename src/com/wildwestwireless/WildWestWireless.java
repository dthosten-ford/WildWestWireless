package com.wildwestwireless;

public class WildWestWireless {

    public Double getBill(int phoneLines) {
        if (phoneLines > 1)
            return 64.45;
        return 49.95;
    }
}
