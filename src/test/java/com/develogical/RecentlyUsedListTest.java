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

	@Test(expected = IndexOutOfBoundsException.class)
	public void cannotGetItemThatDoesNotExist() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void cannotGetItemThatDoesNotExistBecauseItIsDuplicate() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item1");
		recentlyUsedList.add("item1");
		recentlyUsedList.get(1);
	}

	@Test
	public void listShouldBeAbleToRetrieveAnOlderThingFromTheList() {
		// also covers theMostRecentItemShouldBeFirstInTheList
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item1");
		recentlyUsedList.add("item2");
		assertThat(recentlyUsedList.get(0), is("item2"));
		assertThat(recentlyUsedList.get(1), is("item1"));
	}

	@Test
	public void itemsInTheListAreUnique() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item1");
		recentlyUsedList.add("item2");
		recentlyUsedList.add("item1");
		assertThat(recentlyUsedList.get(0), is("item1"));
		assertThat(recentlyUsedList.get(1), is("item2"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void itemsInTheListAreUniqueSoDropOffEnd() {
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item1");
		recentlyUsedList.add("item2");
		recentlyUsedList.add("item1");
		recentlyUsedList.get(2);
	}

	@Test
	public void canTellSize() {
		// also covers theMostRecentItemShouldBeFirstInTheList
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item1");
		recentlyUsedList.add("item2");
		assertThat(recentlyUsedList.size(), is(2));
	}

	@Test
	public void canTellSizeRemovingDuplicates() {
		// also covers theMostRecentItemShouldBeFirstInTheList
		RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
		recentlyUsedList.add("item1");
		recentlyUsedList.add("item1");
		assertThat(recentlyUsedList.size(), is(1));
	}
}
