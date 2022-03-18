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
		assertThat(new NumeralsClass(2).asString(), is("II"));
	}

	@Test
	public void canPerform() {
		NumeralsClass nine = new NumeralsClass(9);
		assertThat(nine.asString(), is("IX"));

	}
	@Test
	public void canPerformA() {
		NumeralsClass three = new NumeralsClass(3);
		assertThat(three.asString(), is("III"));
	}
	@Test
	public void canPerformB() {
		NumeralsClass eight = new NumeralsClass(8);
		assertThat(eight.asString(), is("VIII"));
	}
	@Test
	public void canPerformC() {
		NumeralsClass thirtyeight = new NumeralsClass(38);
		assertThat(thirtyeight.asString(), is("XXXVIII"));
	}
	@Test
	public void canPerformD() {
		NumeralsClass fthirtyeight = new NumeralsClass(48);
		assertThat(fthirtyeight.asString(), is("XLVIII"));
	}
}
