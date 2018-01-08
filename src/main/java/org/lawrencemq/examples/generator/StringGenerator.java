package org.lawrencemq.examples.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

	public static String createString(final int keyLength, final int valueLength, final int numKeyValuePairs){
		final String keyValue = RandomStringUtils.randomAlphanumeric(keyLength) + "|" + RandomStringUtils.randomAlphanumeric(valueLength);
		final StringBuilder builder = new StringBuilder("\t");
		for(int i = 0; i < numKeyValuePairs; ++i){
			builder.append(keyValue);
		}
		return builder.toString();
	}

}
