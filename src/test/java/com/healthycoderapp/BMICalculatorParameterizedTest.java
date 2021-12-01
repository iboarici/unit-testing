package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(doubles = {70.0, 95.0, 110.0})
    void should_ReturnTrue_WhenDietRecommended(Double weight) {
        //given
        double height = 1.72;
        //when
        boolean isDietRecommended = BMICalculator.isDietRecommended(weight, height);
        //then
        assertTrue(isDietRecommended);
    }
}