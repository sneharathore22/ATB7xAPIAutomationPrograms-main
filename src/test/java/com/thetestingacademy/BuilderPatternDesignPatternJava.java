package com.thetestingacademy;

public class BuilderPatternDesignPatternJava {

    public BuilderPatternDesignPatternJava Stage1() {
        System.out.println("Stage 1 is Done");
        return this;

    }

    public BuilderPatternDesignPatternJava Stage2(String param) {
        System.out.println("Stage 2 is Done");
        return this;

    }

    public BuilderPatternDesignPatternJava Stage3() {
        System.out.println("Stage 3 is Done");
        return this;

    }

    public static void main(String[] args) {
        BuilderPatternDesignPatternJava bp = new BuilderPatternDesignPatternJava();
        bp.Stage1().Stage2("Shuchi").Stage3();
    }
}
