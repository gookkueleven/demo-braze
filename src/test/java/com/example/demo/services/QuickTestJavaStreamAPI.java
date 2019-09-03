package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QuickTestJavaStreamAPI {

    @Test
    public void testStreamFilter() {

        List<String> stringList = Stream.of("Peter", "MJ", "May").collect(Collectors.toList());

        String filteredValue = stringList.stream()
                .filter(name -> !"peter".equalsIgnoreCase(name))
                .collect(Collectors.joining(", "));

        assertEquals("MJ, May", filteredValue);
    }

    @Test
    public void testStreamFilter_return_toList() {
        List<String> stringList = Stream.of("Peter", "MJ", "May").collect(Collectors.toList());

        List<String> filteredValue = stringList.stream()
                .filter(name -> !"peter".equalsIgnoreCase(name))
                .collect(Collectors.toList());

        assertEquals(2, filteredValue.size());
    }

    @Test
    public void testStreamMap_return_newString() {

        List<String> stringList = Stream.of("Peter", "MJ", "May").collect(Collectors.toList());

        List<String> uppercaseString = stringList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(stringList);
        System.out.println(uppercaseString);
    }

    @Test
    public void testStream_sum_value_mapToInt() {
        List<Integer> integers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        int sum = integers.stream().mapToInt(Integer::intValue).sum();

        assertEquals(15, sum);
    }

    @Test
    public void testStream_sum_value_reduce() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = integers.stream().reduce(0, Integer::sum);

        assertEquals(15, sum);
    }
}
