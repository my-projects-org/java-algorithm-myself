package com.algorithm.programmers.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Q43165Test {

    @ParameterizedTest
    @MethodSource("paramProvider")
    void solution(int[] numbers, int target, int expect) {
        Q43165 q43165 = new Q43165();
        int solution = q43165.solution(numbers, target);
        Assertions.assertThat(solution).isEqualTo(expect);
    }

    static Stream<Arguments> paramProvider() {
        int[] array1 = {1,1,1,1,1};
        return Stream.of(Arguments.of( array1,3, 5 ));
    }
}