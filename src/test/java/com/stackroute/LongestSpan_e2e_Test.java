package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LongestSpan_e2e_Test {

	private static final String MSG_01 = "The method should display the number x along with its longest span y in format x:y";
	private static final String MSG_02 = "Method should display -1 for Empty array";
	private static final String MSG_03 = "if numbers have the same longest span, then the larger number and its  Then index of larger number of the larger number and its span should be returned";

	private String input;
	private String expected;
	private String message;

	private PrintStream out;
	private ByteArrayOutputStream myOutStream;
	private InputStream in;
	private ByteArrayInputStream myInputStream;

	public LongestSpan_e2e_Test(String input, String expected, String message) {
		super();
		this.input = input;
		this.expected = expected;
		this.message = message;
	}

	@Before
	public void setUp() {
		in = System.in;
		out = System.out;
		myOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOutStream));
	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}

	@Parameters(name = "{index}: Main Method Input ({0}) - Should display ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "5 7 6 7 7 6", "7:4", MSG_01 });
		params.add(new Object[] { "5 7 6 7 5 7", "7:5", MSG_03 });
		params.add(new Object[] { "0", "Empty Array", MSG_02 });

		return params;
	}

	@Test
	public void testfindLargestDifference() {
		myInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(myInputStream);

		LongestSpan.main(null);
		String actual = myOutStream.toString().replaceAll("\\s+", "");
		assertThat(message, actual, is(expected.replaceAll("\\s+", "")));
	}
}