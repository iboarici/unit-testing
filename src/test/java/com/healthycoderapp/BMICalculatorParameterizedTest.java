package com.healthycoderapp;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(doubles = {89.0, 95.0, 110.0})
    void should_ReturnTrue_WhenDietRecommended(Double weight) {
        //given
        double height = 1.72;
        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(isDietRecommended);
    }

    @ParameterizedTest
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    void should_ReturnTrue_WhenDietRecommended(Double weight, Double height) {
        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(isDietRecommended);
    }

    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
    void should_ReadFromFile_ReturnTrue_WhenDietRecommended(Double weight, Double height) {
        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(isDietRecommended);
    }

}