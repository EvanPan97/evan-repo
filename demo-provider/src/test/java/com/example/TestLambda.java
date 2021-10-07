package com.example;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

@SpringBootTest
public class TestLambda {
    @Test
    public void TestLambda() {
        String[] atp = {
                "Rafael Nadal",
                "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer",
                "Roger Federer",
                "Andy Murray",
                "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        players.forEach((player) -> {
            System.out.println(player);
        });

        IntBinaryOperator ibo = (a, b) -> (b - a);
        System.out.println(ibo.applyAsInt(1, 2));
    }
}
