package com.christianhujer.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

public enum PrimeFactors {
    ;

    @SuppressWarnings("PMD.AvoidReassigningParameters")
    static List<Integer> factorsOf(int number) {
        final List<Integer> factors = new ArrayList<>();
        for (int divisor = 2; number >= divisor; divisor++)
            for (; number % divisor == 0; number /= divisor)
                factors.add(divisor);
        return factors;
    }
}
