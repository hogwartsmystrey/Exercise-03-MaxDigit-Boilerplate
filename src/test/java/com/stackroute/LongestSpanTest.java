package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LongestSpanTest {

	private static final String MSG_01 = "The method should return the number x alongwith its longest span y in format x:y";
	private static final String MSG_02 = "Method should return -1 for Null, Empty array";
	private static final String MSG_03 = "if numbers have the same longest span, then the larger number and its  Then index of larger number of the larger number and its span should be returned";

	private int[] input;
	private String expected;
	private String message;
	private String inputArrayContent;

	public LongestSpanTest(int[] input, String expected, String message, String inputArrayContent) {
		super();
		this.input = input;
		this.expected = expected;
		this.message = message;
		this.inputArrayContent = inputArrayContent;

	}

	@Parameters(name = "{index}: findLongestSpan({3}) - Should Return ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		int[] inputArray = new int[] { 4, 2, 4, 2, 4 };
		params.add(new Object[] { inputArray, "4:5", MSG_01, Arrays.toString(inputArray) });
		inputArray = new int[] { 9, 1, 9, 3, 3, 9, 1 };
		params.add(new Object[] { inputArray, "9:6", MSG_03, Arrays.toString(inputArray) });

		return params;
	}

	@Test
	public void testfindLargestDifference() {
		assertThat(message, LongestSpan.findLongestSpan(input), is(expected));
	}

}
