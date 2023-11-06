package com.example.t1test.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculateFrequency")
public class FrequencyController {
    @GetMapping("/{input}")
    public Map<Character, Long> sortFrequency(@PathVariable String input) {

        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<Character, Long> sortedMap = new TreeMap<>((c1, c2) -> {
            int compare = frequencyMap.get(c2).compareTo(frequencyMap.get(c1));
            if (compare == 0) {
                return c1.compareTo(c2);
            }
            return compare;
        });
        sortedMap.putAll(frequencyMap);

        return sortedMap;
    }

    @GetMapping("/")
    public Map<Character, Long> handleEmptyInput() {
        return Collections.emptyMap();
    }
}
