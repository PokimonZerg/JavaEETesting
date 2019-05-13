package ru.otus.qa.automation.arquillian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest
{
    @Spy
    private FirstBean firstBean = new FirstBean();

    @InjectMocks
    private SecondBean secondBean;

    @Test
    public void testNumberWithMockito()
    {
        assertEquals(42, secondBean.getMyFavoriteNumber());
    }
}
