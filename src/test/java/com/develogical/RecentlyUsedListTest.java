package com.develogical;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecentlyUsedListTest {
	@Test 
	public void listShouldBeEmptyWhenInitialised() {
		assertThat(new RecentlyUsedList().isEmpty(), is(true));
	}

	@Test
	public void listShouldBeAbleToAddThingsToTheList() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item");
		assertThat(recentlyUsedList.isEmpty(), is(false));
	}

	@Test
	public void listShouldBeAbleToRetrieveThingsFromTheList() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item");
		assertThat(recentlyUsedList.get(0), is("item"));
	}

	@Test
	public void listShouldBeAbleToRetrieveAnotherThingFromTheList() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item2");
		assertThat(recentlyUsedList.get(0), is("item2"));
	}
}
