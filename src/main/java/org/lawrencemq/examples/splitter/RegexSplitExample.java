package org.lawrencemq.examples.splitter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexSplitExample {

	private static final String MESSAGE_SPLIT_REGEX = "\\t";
	private static final Pattern MESSAGE_PATTERN_FOR_SPLIT = Pattern.compile(MESSAGE_SPLIT_REGEX);

	private static void efficientParsePairAndAddToMap(final Map<String, String> parsedMap, final String pair) {
		final int pipeIndex = pair.indexOf('|');

		final String key = pair.substring(0, pipeIndex);
		final String value = pair.substring(pipeIndex + 1);

		parsedMap.put(key, value);
	}

	public static Map<String, String> splitStringToMap(final String string, final int expectedSize) {
		final Map<String, String> parsedMap = new HashMap<>(2*expectedSize);
		for(final String pair : MESSAGE_PATTERN_FOR_SPLIT.split(string.trim())) {
			efficientParsePairAndAddToMap(parsedMap, pair);
		}
		return parsedMap;
	}


}
