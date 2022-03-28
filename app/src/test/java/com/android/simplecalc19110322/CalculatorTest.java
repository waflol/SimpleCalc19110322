package com.android.simplecalc19110322;






import static org.junit.Assert.assertEquals;
import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() throws Exception{
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 2d);
        assertEquals(resultAdd,3d,0.000000d);
    }
    @Test
    public void addTwoNumbersFloat() {
        double resultAdd = mCalculator.add(.1d, .2d);
        double diff = Math.pow(10,-15);
        assertEquals(resultAdd,.3d,diff);
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertEquals(resultAdd, 1d,0d);
    }
    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        double diff = Math.pow(10,-7);
        assertEquals(resultAdd, 2.222,diff);
    }
    @Test
    public void subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertEquals(resultSub, 0d,0d);
    }
    @Test
    public void subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertEquals(resultSub, -16d,0d);
    }
    @Test
    public void mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertEquals(resultMul, 64d,0d);
    }
    @Test
    public void divTwoNumbers() {
        double resultDiv = mCalculator.div(32d,2d);
        assertEquals(resultDiv, 16d,0d);
    }
    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows(){
        try{
            double resultDiv = mCalculator.div(32d, 0);
        }
        catch (Exception e){
            System.out.println("ERROR BY DIV ZERO!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test
    public void powNumber(){
        double resultPow = mCalculator.pow(3d,2f);
        assertEquals(resultPow, 9d,0d);
    }
    @Test
    public void powNumberWithNegative(){
        double resultPow = mCalculator.pow(2d,-2f);
        assertEquals(resultPow, 0.25,0d);
    }
    @Test
    public void powNumberWithBase(){
        double resultPow = mCalculator.pow(-2d,5d);
        assertEquals(resultPow, -32d,0d);
    }
    @Test
    public void powNumberWithBaseResultPos(){
        double resultPow = mCalculator.pow(-3d,4d);
        assertEquals(resultPow, 81d,0d);
    }
    @Test
    public void powNumberWithBaseFloatPos(){
        double resultPow = mCalculator.pow(.1d,2d);
        double diff = Math.pow(10,-7);
        assertEquals(resultPow, .01d,diff);
    }

    @Test(expected = IllegalArgumentException.class)
    public void powNumberZerovsZero(){
        try{
            double resultPow = mCalculator.pow(0d,0d);
        }
        catch (Exception e){
            System.out.println("ERROR POW ZERO ZERO!!");
        }
        finally {
            throw new IllegalArgumentException();
        }


    }

    @Test
    public void powNumberWithBaseFloatNeg(){
        double resultPow = mCalculator.pow(-.1d,2d);
        double diff = Math.pow(10,-7);
        assertEquals(resultPow, .01d,diff);
    }

    @Test
    public void powNumberWithBaseFloatOddNeg(){
        double resultPow = mCalculator.pow(-.1d,3d);
        double diff = Math.pow(10,-7);
        assertEquals(resultPow, -.001d,diff);
    }
    @Test
    public void FacPosNumber(){
        double resultFac = mCalculator.fac(3d);
        assertEquals(resultFac, 6d,0d);
    }
    @Test(expected = IllegalArgumentException.class)
    public void FacRadNumber(){
        try{
            double resultFac = mCalculator.fac(3.5d);
        }
        catch (Exception e){
            System.out.println("ERROR BY FLOAT NUMBER!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void FacNegNumber(){
        try{
            double resultFac = mCalculator.fac(-9d);
        }
        catch (Exception e){
            System.out.println("ERROR BY NEGATIVE NUMBER!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test
    public void FacZeroNumber(){
        double resultFac = mCalculator.fac(0d);
        assertEquals(resultFac, 1d,0d);
    }

    @Test
    public void LogNormalNumber(){
        double resultLog = mCalculator.log(27d,3d);
        assertEquals(resultLog, 3d,0d);
    }

    @Test
    public void LogNormalNumber2(){
        double resultLog = mCalculator.log(3d,27d);
        double resultDiv = mCalculator.div(1,3);
        double diff = Math.pow(10,-10);
        assertEquals(resultLog, resultDiv,diff);
    }
    @Test(expected = IllegalArgumentException.class)
    public void LogZeroNumber(){
        try{
            double resultLog = mCalculator.log(0d,2d);
        }
        catch (Exception e){
            System.out.println("ERROR BY LOG ZERO NUMBER!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void LogNegNumber(){
        try{
            double resultLog = mCalculator.log(-9d,9d);
        }
        catch (Exception e){
            System.out.println("ERROR BY LOG NEG NUMBER!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void LogBaseZeroNumber(){
        try{
            double resultLog = mCalculator.log(2d,0d);
        }
        catch (Exception e){
            System.out.println("ERROR BY LOG NUMBER WITH ZERO BASE!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void LogBaseNegNumber(){
        try{
            double resultLog = mCalculator.log(2d,-1d);
        }
        catch (Exception e){
            System.out.println("ERROR BY LOG NUMBER WITH NEG BASE!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void LogBaseOneNumber(){
        try{
            double resultLog = mCalculator.log(2d,1d);
        }
        catch (Exception e){
            System.out.println("ERROR BY LOG NUMBER WITH ONE BASE!!");
        }
        finally {
            throw new IllegalArgumentException();
        }
    }
    @Test
    public void LogFloatNumber(){
        double resultLog = mCalculator.log(.00001d,.01d);
        double diff = Math.pow(10,-10);
        assertEquals(resultLog, 2.5d,diff);
    }
    @Test
    public void LogFloatNumber2(){
        double resultLog = mCalculator.log(.00243d,.3d);
        assertEquals(resultLog, 5d,0d);
    }
}
