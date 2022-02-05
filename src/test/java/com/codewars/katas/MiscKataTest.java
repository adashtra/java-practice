package com.codewars.katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiscKataTest {
    @Test
    public void abbrevNameTest() {
        assertEquals("S.H", MiscKata.abbrevName("Sam Harris"));
        assertEquals("P.F", MiscKata.abbrevName("Patrick Feenan"));
        assertEquals("E.C", MiscKata.abbrevName("Evan Cole"));
        assertEquals("P.F", MiscKata.abbrevName("P Favuzzi"));
        assertEquals("D.M", MiscKata.abbrevName("David Mendieta"));
    }
}