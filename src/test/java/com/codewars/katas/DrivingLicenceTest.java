package com.codewars.katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrivingLicenceTest {
    @Test
    public void basicTests()
    {
        assertEquals("SMITH001010JJ9AA", DrivingLicence.driver(new String[]{"John",    "James",  "Smith", "01-Jan-2000",       "M"}));
        assertEquals("GIBBS862131J99AA", DrivingLicence.driver(new String[]{"Johanna", "",       "Gibbs", "13-Dec-1981",       "F"}));
        assertEquals("LEE99809021AR9AA", DrivingLicence.driver(new String[]{"Andrew",  "Robert", "Lee",   "02-September-1981", "M"}));
    }

}