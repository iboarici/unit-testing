package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_WhenDietRecommended() {
        //given
        double weight = 89.0;
        double height = 1.72;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(isDietRecommended);
    }

    @Test
    void should_ReturnFalse_WhenDietNotRecommended() {
        //given
        double weight = 59.0;
        double height = 1.92;

        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(isDietRecommended);
    }

    @Test
    void should_ThrowArithmeticException_WhenHeightZero() {
        //given
        double weight = 59.0;
        double height = 0;

        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        //then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
        //Given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        //When
        double expectedHeight = 1.82;
        double expectedWeight = 98.0;
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //Then
        assertAll(
                () -> assertEquals(expectedHeight, coderWorstBMI.getHeight()),
                () -> assertEquals(expectedWeight, coderWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNullWorstBMI_When_CoderListEmpty() {
        //Given
        List<Coder> coders = new ArrayList<>();

        //When
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        //Then
        assertNull(coderWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_WhenCoderListNotEmpty() {
        //Given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80, 60.0));
        coders.add(new Coder(1.82, 98.0));
        coders.add(new Coder(1.82, 64.7));

        //When
        double[] bmiScores = BMICalculator.getBMIScores(coders);
        double[] expected = {18.52, 29.59, 19.53};

        //Then
        assertArrayEquals(expected, bmiScores);
    }
}