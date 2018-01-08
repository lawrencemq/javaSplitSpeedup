package org.lawrencemq.examples;

import org.lawrencemq.examples.generator.StringGenerator;
import org.lawrencemq.examples.splitter.RegexSplitExample;
import org.lawrencemq.examples.splitter.StringSplitExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExampleRunner {

	private final static int TIMES_TO_PARSE = 1_000_000_000;
	private final static int KEY_PAIR_LENGTH = 10;

	public static void main(final String[] cheese){
		final List<Integer> numberOfPairsToAttempt = Arrays.asList(10_000_000, 1_000_000, 100_000, 10_000, 1_000, 100, 10, 1);
		for(final int numPairs : numberOfPairsToAttempt){
			final String exampleString = StringGenerator.createString(KEY_PAIR_LENGTH, KEY_PAIR_LENGTH, numPairs);
			runSplit(numPairs, exampleString);
			runRegex(numPairs, exampleString);
		}
	}

	private static void runSplit(final int numPairs, final String exampleString) {
		final long before = System.nanoTime();
		IntStream.of(TIMES_TO_PARSE).forEach(j -> StringSplitExample.splitStringToMap(exampleString, numPairs));
		final long after = System.nanoTime();

		final double difference = calculateDifference(before, after);

		System.out.println("Split " + numPairs + " time: " + difference);
	}

	private static void runRegex(final int numPairs, final String exampleString) {
		final long before = System.nanoTime();
		IntStream.of(TIMES_TO_PARSE).forEach(j -> RegexSplitExample.splitStringToMap(exampleString, numPairs));
		final long after = System.nanoTime();

		final double difference = calculateDifference(before, after);
		System.out.println("Regex " + numPairs + " time: " + difference);
	}

	/**
	 * Find the difference in nano-seconds, or 1 billionth of a second
	 */
	private static double calculateDifference(final long before, final long after) {
		return (after - before)/((double) TIMES_TO_PARSE);
	}
}
