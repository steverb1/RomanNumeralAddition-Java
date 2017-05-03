package com.siq.roman;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// Test-driven using this algorithm: http://turner.faculty.swau.edu/mathematics/materialslibrary/roman/

public class AdderTests
{
    Adder adder;

    @Before
    public void setup()
    {
        adder = new Adder();
    }

    @Test
    public void sumOfIAndIShouldBeII()
    {
        assertEquals("II", adder.add("I", "I"));
    }

    @Test
    public void sumOfIAndIIShouldBeIII()
    {
        assertEquals("III", adder.add("I", "II"));
    }

    @Test
    public void sumOfIAndIIIShouldBeIV()
    {
        assertEquals("IV", adder.add("I", "III"));
    }

    @Test
    public void sumOfIIAndIIShouldBeIV()
    {
        assertEquals("IV", adder.add("II", "II"));
    }

    @Test
    public void sumOfIIAndIIIShouldBeV()
    {
        assertEquals("V", adder.add("II", "III"));
    }

    @Test
    public void sumOfVAndIShouldBeVI()
    {
        assertEquals("VI", adder.add("V", "I"));
    }

    @Test
    public void sumOfIAndVShouldBeVI()
    {
        assertEquals("VI", adder.add("I", "V"));
    }

    @Test
    public void sumOfIVAndIShouldBeV()
    {
        assertEquals("V", adder.add("IV", "I"));
    }

    @Test
    public void sumOfIAndIVShouldBeV()
    {
        assertEquals("V", adder.add("I", "IV"));
    }

    @Test
    public void sumOfVAndVShouldBeX()
    {
        assertEquals("X", adder.add("V", "V"));
    }

    @Test
    public void sumOfVIVAndIShouldBeX()
    {
        assertEquals("X", adder.add("VIV", "I"));
    }

    @Test
    public void sumOfIXVAndIShouldBeX()
    {
        assertEquals("X", adder.add("IX", "I"));
    }

    @Test
    public void sumOfCCCLXIXAndDCCCXLVShouldBeMCCXIV()
    {
        assertEquals("MCCXIV", adder.add("CCCLXIX", "DCCCXLV"));
    }
}
