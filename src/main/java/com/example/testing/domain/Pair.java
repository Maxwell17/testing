package com.example.testing.domain;

/**
 * Generic record stores pairs of elements in the memory
 *
 * @param first  left element
 * @param second right element
 * @param <T1>   type of left element
 * @param <T2>   type of right element
 */
public record Pair<T1, T2>(T1 first, T2 second) {
}
