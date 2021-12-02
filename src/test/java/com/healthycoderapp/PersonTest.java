package com.healthycoderapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("iboarici", "Istanbul");
    }

    @Test
    void givenBean_whenHasValue_thenCorrect() {
        assertThat(person, hasProperty("name", equalTo("iboarici")));
    }
}