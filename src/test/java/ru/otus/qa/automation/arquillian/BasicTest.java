package ru.otus.qa.automation.arquillian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicTest
{
    @Test
    public void testNumber() {
        SecondBean secondBean = new SecondBean();

        assertEquals(42, secondBean.getMyFavoriteNumber());
    }
}
