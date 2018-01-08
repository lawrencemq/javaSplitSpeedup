package org.lawrencemq.examples.splitter;


import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SplitExampleTest {


	private static final String exampleEntry = "a|1\tbee|two\tsee|three\twhy|not\tzoidburg|?";

	private static final Map<String, String> expectedAnswer = createExpectedMap();

	private static Map<String, String> createExpectedMap() {
		return Collections.unmodifiableMap(new HashMap<String, String>(){{
			put("a", "1");
			put("bee", "two");
			put("see", "three");
			put("why", "not");
			put("zoidburg", "?");
		}});

	}

	@Test
	public void regexStringToMap() throws Exception {
		compare(RegexSplitExample.splitStringToMap(exampleEntry, 5));
	}

	@Test
	public void splitStringToMap() throws Exception {
		compare(StringSplitExample.splitStringToMap(exampleEntry, 5));
	}

	private void compare(final Map<String, String> result){
		assertEquals(result.size(), 5);
		expectedAnswer.entrySet().stream().forEach(entry -> {
			assertTrue(result.containsKey(entry.getKey()));
			assertEquals(result.get(entry.getKey()), entry.getValue());
		});
	}


}
