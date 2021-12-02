package com.healthycoderapp.junit5;

import com.healthycoderapp.Coder;
import com.healthycoderapp.DietPlan;
import com.healthycoderapp.DietPlanner;
import com.healthycoderapp.Gender;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all unit tests...");
    }

    @BeforeEach
    void setUp() {
        dietPlanner = new DietPlanner(20, 30, 50);
        System.out.println("Unit Test has started...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Unit Test has finished...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all unit tests...");
    }

    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //Given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);

        //When
        DietPlan actualDietPlan =  dietPlanner.calculateDiet(coder);

        //Then
        assertEquals(expectedDietPlan, actualDietPlan);
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void should_ReturnCorrectDietPlan_When_CorrectCoder_MultipleTimes() {
        //Given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expectedDietPlan = new DietPlan(2202, 110, 73, 275);

        //When
        DietPlan actualDietPlan =  dietPlanner.calculateDiet(coder);

        //Then
        assertEquals(expectedDietPlan, actualDietPlan);
    }
}