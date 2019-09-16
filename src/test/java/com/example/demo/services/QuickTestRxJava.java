package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.reactivex.Observable;

@RunWith(SpringRunner.class)
public class QuickTestRxJava {

    private static String name;
    private static String errorMess;

    @Test
    public void testRxjava_simple() {

        Observable<String> sObservable = Observable.just("Kook");

        sObservable.subscribe(item -> System.out.println(item));
    }

    @Test
    public void testRxjava_moderate() {

        List<String> stringList = Stream.of("kook", "tep", "kod").collect(Collectors.toList());

        Observable<String> sObservable = Observable.create(emitter -> {

            for (String item : stringList) {
                if ("kod".equalsIgnoreCase(item)) {
                    emitter.onError(new Exception("Error naja"));
                }
                emitter.onNext(item);
            }
            emitter.onComplete();
        });

        sObservable.subscribe(data -> {
            name = getString(data);
        }, error -> {
            errorMess = error.getMessage();
        }
        ).dispose();

        assertEquals("tep", name);
        assertEquals("Error naja", errorMess);
    }

    @Test
    public void testRxjava_moderate_when_error_it_will_stop_working() {

        List<String> stringList = Stream.of("kook", "kod", "tep").collect(Collectors.toList());

        Observable<String> sObservable = Observable.create(emitter -> {

            for (String item : stringList) {
                if ("kod".equalsIgnoreCase(item)) {
                    emitter.onError(new Exception("Error naja"));
                }
                emitter.onNext(item);
            }
            emitter.onComplete();
        });

        sObservable.subscribe(data -> {
            name = getString(data);
        }, error -> {
            errorMess = error.getMessage();
        }
        ).dispose();

        assertEquals("kook", name);
        assertEquals("Error naja", errorMess);
    }

    public String getString(String name) {
        return name;
    }
}