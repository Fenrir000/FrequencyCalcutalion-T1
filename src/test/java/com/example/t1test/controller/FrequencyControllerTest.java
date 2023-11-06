package com.example.t1test.controller;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class FrequencyControllerTest {


    @Test
    public void testSortFrequencyForaaaaabcccc() {
        FrequencyController controller = new FrequencyController();

        Map<Character, Long> result = controller.sortFrequency("aaaaabcccc");

        List<Character> expectedOrder = List.of('a', 'c', 'b');
        List<Character> actualOrder = new ArrayList<>(result.keySet());

        assertEquals(expectedOrder, actualOrder);


        List<Long> expectedFrequencyOrder = List.of(5L, 4L, 1L);
        List<Long> actualFrequencyOrder = new ArrayList<>(result.values());

        assertEquals(expectedFrequencyOrder, actualFrequencyOrder);
    }

    @Test
    public void testSortFrequencyForassaaabccccc() {
        FrequencyController controller = new FrequencyController();

        Map<Character, Long> result = controller.sortFrequency("cassaaabccccc");

        List<Character> expectedOrder = List.of('c', 'a', 's', 'b');
        List<Character> actualOrder = new ArrayList<>(result.keySet());

        assertEquals(expectedOrder, actualOrder);


        List<Long> expectedFrequencyOrder = List.of(6L, 4L, 2L, 1L);
        List<Long> actualFrequencyOrder = new ArrayList<>(result.values());

        assertEquals(expectedFrequencyOrder, actualFrequencyOrder);
    }

    @Test
    public void testSortFrequencyForabcWithSpaces() {
        FrequencyController controller = new FrequencyController();

        Map<Character, Long> result = controller.sortFrequency("a b c");

        List<Character> expectedOrder = List.of(' ', 'a', 'b', 'c');
        List<Character> actualOrder = new ArrayList<>(result.keySet());

        assertEquals(expectedOrder, actualOrder);


        List<Long> expectedFrequencyOrder = List.of( 2L, 1L, 1L,1L);
        List<Long> actualFrequencyOrder = new ArrayList<>(result.values());

        assertEquals(expectedFrequencyOrder, actualFrequencyOrder);
    }
    @Test
    public void testHandleEmptyInput() {
        FrequencyController controller = new FrequencyController();


        Map<Character, Long> result = controller.handleEmptyInput();


        assertTrue(result.isEmpty());
    }
}