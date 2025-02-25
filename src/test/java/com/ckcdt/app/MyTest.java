package com.ckcdt.app;
import java.util.Random;


import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class MyTest{
    @Test
    public void testLogic(){
        Random rand = new Random();
        double num;
        for(int i = 0; i < 100; i++){
             num = rand.nextInt(1000);
            assertTrue(com.ckcdt.app.Main.round(num/100, 0) == Math.round(num/100));
        }
        assertThrows(
            java.io.FileNotFoundException.class,
            () -> com.ckcdt.app.Main.fileToStr("non-existant file name.txt")
        );  
        double base;
        int exponent;
        for(int i = 0; i < 100; i++){
            base = rand.nextDouble();
            exponent = rand.nextInt(10);
            assertTrue(Math.abs(com.ckcdt.app.Main.potency(base, exponent) - Math.pow(base, exponent)) < 0.01);
        }
    }    
}
