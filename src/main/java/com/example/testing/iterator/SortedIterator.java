package com.example.testing.iterator;

import com.example.testing.domain.Pair;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class SortedIterator implements Iterator<Pair<Integer, Integer>> {

    /**
     * Used to store pairs, sorting pairs by first
     */
    private final Queue<Pair<Integer, Integer>> pairs = new PriorityQueue<>(comparingInt(Pair::first));

    public SortedIterator(final Map<Integer, Iterator<Integer>> iterators) {
        iterators.forEach((num, it) -> it.forEachRemaining(digit -> pairs.add(new Pair<>(digit, num))));
    }

    /**
     * Checks whether there is some pairs in queue
     *
     * @return true if there is some pair, otherwise false
     */
    @Override
    public boolean hasNext() {
        return !this.pairs.isEmpty();
    }

    /**
     * Get next pair from queue
     *
     * @return pair of digit and number of iterator
     */
    @Override
    public Pair<Integer, Integer> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return pairs.poll();
    }

}
