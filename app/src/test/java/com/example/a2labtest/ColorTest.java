package com.example.a2labtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorTest {
    @Test
    public void greenColor(){
        Green green=new Green();
        assertEquals("Green",green.showColor());

    }
    @Test
    public void blueColor(){
        Blue blue=new Blue();
        assertEquals("Blue",blue.showColor());
    }
    @Test
    public void redColor(){
        Red red=new Red();
        assertEquals("Red",red.showColor());
    }

}