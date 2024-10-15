package com.thetestingacademy.ex_1410;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG005 {

    @Parameters("browser")
    @Test
    void demo1(String value){
        System.out.println("Browser is "+value);
    }
}
