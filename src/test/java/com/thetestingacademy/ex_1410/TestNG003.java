package com.thetestingacademy.ex_1410;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG003 {


    @Test(groups = {"sanity","qa","preprod"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }


    @Test(groups = {"dev","stage"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
