package org.lawrencemq.examples.splitter;

import java.util.HashMap;
import java.util.Map;

public class StringSplitExample {

	private static void inefficientParsePairAndAddToMap(final Map<String, String> parsedMap, final String pair){
		final String[] keyAndValue = pair.split("\\|");
		parsedMap.put(keyAndValue[0], keyAndValue[1]);
	}

	public static Map<String, String> splitStringToMap(final String string, final int expectedSize) {
		final Map<String, String> parsedMap = new HashMap<>(2*expectedSize);
		for(final String pair : string.trim().split("\\t")){
			inefficientParsePairAndAddToMap(parsedMap, pair);
		}
		return parsedMap;
	}
}
