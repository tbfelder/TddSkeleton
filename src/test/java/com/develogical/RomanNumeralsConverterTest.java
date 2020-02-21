package com.develogical;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RomanNumeralsConverterTest {
	private void check(int arabic, String roman) {
		assertThat(inRomanNumerals(arabic), is(roman));
		assertThat(romanAsInt(roman), is(arabic));
	}

	@Test
	public void convertsUpTo3() {
		check(1, "I");
		check(2, "II");
		check(3, "III");
	}

	@Test
	public void fourIsSpecial() {
		check(4, "IV");
	}

	@Test
	public void converts5To8() {
		check(5, "V");
		check(6, "VI");
		check(7, "VII");
		check(8, "VIII");
	}

	@Test
	public void converts10to20() {
		check(10, "X");
		check(11, "XI");
		check(12, "XII");
		check(13, "XIII");
		check(14, "XIV");
		check(15, "XV");
		check(16, "XVI");
		check(17, "XVII");
		check(18, "XVIII");
		check(19, "XIX");
		check(20, "XX");
	}

	@Test
	public void converts20AndBeyond() {
		check(21, "XXI");
		check(31, "XXXI");
		check(24, "XXIV");
	}

	@Test
	public void fortyIsSpecial() {
		check(40, "XL");
	}

	@Test
	public void converts50AndBeyond() {
		check(50, "L");
		check(51, "LI");
		check(64, "LXIV");
	}

	@Test
	public void fortiesAreSpecial() {
		check(41, "XLI");
		check(44, "XLIV");
	}

	@Test
	public void nineIsSpecial() {
		check(9, "IX");
	}

	@Test
	public void ninetyIsSpecial() {
		check(90, "XC");
	}

	@Test
	public void ninetiesAreSpecial() {
		check(91, "XCI");
		check(94, "XCIV");
		check(96, "XCVI");
		check(99, "XCIX");
	}

	@Test
	public void converts100AndBeyond() {
		check(100, "C");
		check(101, "CI");
		check(369, "CCCLXIX");
	}

	@Test
	public void handles400s() {
		check(448, "CDXLVIII");
	}

	@Test
	public void handles500sAndBeyond() {
		check(548, "DXLVIII");
	}

	@Test
	public void handles1900sAndBeyond() {
		check(1998, "MCMXCVIII");
		check(2751, "MMDCCLI");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cannotDoZero() {
		inRomanNumerals(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cannotDoNegative() {
		inRomanNumerals(-1);
	}

	private static class Boundary {
		final String representation;
		final int amount;

		private Boundary(String representation, int amount) {
			this.representation = representation;
			this.amount = amount;
		}

		private static Boundary boundary(String representation, int amount) {
			return new Boundary(representation, amount);
		}
	}

	private String inRomanNumerals(int i) {
		List<Boundary> boundaries = asList(
				Boundary.boundary("M", 1000),
				Boundary.boundary("CM", 900),
				Boundary.boundary("D", 500),
				Boundary.boundary("CD", 400),
				Boundary.boundary("C", 100),
				Boundary.boundary("XC", 90),
				Boundary.boundary("L", 50),
				Boundary.boundary("XL", 40),
				Boundary.boundary("X", 10),
				Boundary.boundary("IX", 9),
				Boundary.boundary("V", 5),
				Boundary.boundary("IV", 4),
				Boundary.boundary("I", 1)
		);
		Optional<Boundary> exactMatch = boundaries.stream().filter(b -> b.amount == i).findFirst();
		if (exactMatch.isPresent()) {
			return exactMatch.get().representation;
		}
		Optional<Boundary> topBoundary = boundaries.stream().filter(b -> i > b.amount).findFirst();
		if (topBoundary.isPresent()) {
			Boundary boundary = topBoundary.get();
			return inRomanNumerals(boundary.amount) + inRomanNumerals(i - boundary.amount);
		}
		throw new IllegalArgumentException();
	}

	private int romanAsInt(String roman) {
		Map<Character, Integer> charMappings = new HashMap<>();
		charMappings.put('I', 1);
		charMappings.put('V', 5);
		charMappings.put('X', 10);
		charMappings.put('L', 50);
		charMappings.put('C', 100);
		charMappings.put('D', 500);
		charMappings.put('M', 1000);
		int result = 0;
		for (int i = 0; i < roman.length(); i++) {
			char c = roman.charAt(i);
			boolean subtraction = false;
			int charValue = charMappings.get(c);
			if (i < roman.length() - 1) {
				subtraction = charValue < charMappings.get(roman.charAt(i + 1));
			}
			if (subtraction) {
				result -= charValue;
			} else {
				result += charValue;
			}
		}
		return result;
	}
}
