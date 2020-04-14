package com.christianhujer.kata.primefactors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.christianhujer.kata.primefactors.PrimeFactors.factorsOf;
import static java.util.function.Predicate.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PrimeFactorsTest {
    @ParameterizedTest
    @CsvSource({
            "0, ''",
            "1, ''",
            "2, '2'",
            "3, '3'",
            "4, '2, 2'",
            "5, '5'",
            "6, '2, 3'",
            "7, '7'",
            "8, '2, 2, 2'",
            "9, '3, 3'"
    })
    void factors(final int number, final String expectedFactors) {
        assertThat(factorsOf(number), equalTo(parseNumbers(expectedFactors)));
    }

    List<Integer> parseNumbers(final String numbers) {
        return Stream
                .of(numbers.split(", *"))
                .filter(not(String::isEmpty))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
