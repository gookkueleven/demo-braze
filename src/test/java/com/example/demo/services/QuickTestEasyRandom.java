package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.models.testModels.Employee;
import com.example.demo.models.testModels.TestSerializeModel;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.jeasy.random.randomizers.number.IntegerRandomizer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class QuickTestEasyRandom {

    private static final EasyRandom EASY_RANDOM = new EasyRandom();

    @Test
    public void testEasyRandom_Random_An_Object_Value() {
        TestSerializeModel model = EASY_RANDOM.nextObject(TestSerializeModel.class);

        System.out.println("message is over here");
        System.out.println(model.getInner().getMessage());
    }

    @Test
    public void testEasyRandom_Random_Collection_Of_Objects() {
        List<TestSerializeModel> testSerializeModels = EASY_RANDOM.objects(TestSerializeModel.class, 3)
                .collect(Collectors.toList());

        assertEquals(3, testSerializeModels.size());
    }

    @Test
    public void testEasyRandom_Random_More_Complex_Object() {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters();
        easyRandomParameters.stringLengthRange(3, 3);
        easyRandomParameters.collectionSizeRange(5, 5);
        easyRandomParameters.ignoreRandomizationErrors(true);
        easyRandomParameters.randomize(FieldPredicates.ofType(Integer.class), new IntegerRandomizer());

        EasyRandom easyRandom = new EasyRandom(easyRandomParameters);
        Employee employee = easyRandom.nextObject(Employee.class);

        System.out.println(employee);
    }
}
