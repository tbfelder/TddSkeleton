package com.oocode;

import org.junit.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class ExampleTest {
	@Test 
	public void matchesBasicRomanNumerals() {
		assertThat(RomanNumerals.I.value, is(1));
		assertThat(RomanNumerals.V.value, is(5));
		assertThat(RomanNumerals.X.value, is(10));
		assertThat(RomanNumerals.L.value, is(50));
		assertThat(RomanNumerals.C.value, is(100));
		assertThat(RomanNumerals.D.value, is(500));
		assertThat(RomanNumerals.M.value, is(1000));
	}

	@Test
	public void canPerformAddition() {
		NumeralsClass two = new NumeralsClass(2);
		assertThat(two.RomanNumeral, is("II"));
	}
}
