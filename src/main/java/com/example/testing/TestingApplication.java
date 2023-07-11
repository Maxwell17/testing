package com.example.testing;

import com.example.testing.domain.Pair;
import com.example.testing.iterator.SortedIterator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.split;

public class TestingApplication {

    public static void main(String[] args) {
        printResult(new SortedIterator(inputData()));
    }

    /**
     * Gets data from console
     *
     * @return map which consists digits and number of iterator
     */
    private static Map<Integer, Iterator<Integer>> inputData() {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of arrays (N): ");

        int n = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Enter the arrays in the specified format: ");

        final Map<Integer, Iterator<Integer>> digitsMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Iterator A" + i + ": ");

            digitsMap.put(i, stream(split(scanner.nextLine(), ", "))
                    .map(StringUtils::trim)
                    .map(Integer::parseInt)
                    .iterator());
        }
        return digitsMap;
    }

    /**
     * Print the result in console
     *
     * @param sortedIterator to print in console
     */
    private static void printResult(final SortedIterator sortedIterator) {
        while (sortedIterator.hasNext()) {
            final Pair<Integer, Integer> p = sortedIterator.next();
            System.out.println(p.first() + " " + "(from A" + p.second() + ")");
        }
    }

}
