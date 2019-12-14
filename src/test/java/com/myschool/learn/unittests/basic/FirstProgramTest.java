package com.myschool.learn.unittests.basic;

import com.myschool.learn.basic.FirstProgram;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstProgramTest {
    private FirstProgram classUnderTest;
    private final String expectedMessage ="This is my First Program in Java - Dec 1, 2019 12:22 PM";

    @Before
    public void setup() {
        classUnderTest = new FirstProgram();
    }

    @Test
    public void testFirstProgram() {
        String existingMessage = classUnderTest.getMessage();
        assertEquals(expectedMessage, existingMessage);
    }
}
